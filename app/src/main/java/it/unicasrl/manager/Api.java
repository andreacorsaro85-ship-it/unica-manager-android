package it.unicasrl.manager;

import android.content.Context;
import org.json.JSONObject;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public final class Api {
    public interface Callback { void done(int code, String body, Exception error); }
    private static final ExecutorService EXEC=Executors.newCachedThreadPool();
    public static void get(Context c,String path,Callback cb){ request(c,"GET",path,null,cb); }
    public static void post(Context c,String path,JSONObject json,Callback cb){ request(c,"POST",path,json,cb); }
    public static void request(Context c,String method,String path,JSONObject json,Callback cb){
        EXEC.execute(()->{
            int code=-1; String body=""; Exception err=null;
            try{
                String base=Prefs.base(c); if(base.endsWith("/")) base=base.substring(0,base.length()-1);
                URL u=new URL(base+"/wp-json/unica-manager/v1"+path);
                HttpURLConnection h=(HttpURLConnection)u.openConnection();
                h.setConnectTimeout(15000); h.setReadTimeout(30000); h.setRequestMethod(method); h.setRequestProperty("Accept","application/json");
                String token=Prefs.token(c); if(!token.isEmpty()) h.setRequestProperty("Authorization","Bearer "+token);
                if(json!=null){ byte[] data=json.toString().getBytes(StandardCharsets.UTF_8); h.setDoOutput(true); h.setRequestProperty("Content-Type","application/json; charset=utf-8"); try(OutputStream os=h.getOutputStream()){ os.write(data); } }
                code=h.getResponseCode(); InputStream is=(code>=200&&code<400)?h.getInputStream():h.getErrorStream(); body=read(is);
            }catch(Exception e){ err=e; }
            int fc=code; String fb=body; Exception fe=err; android.os.Handler main=new android.os.Handler(android.os.Looper.getMainLooper()); main.post(()->cb.done(fc,fb,fe));
        });
    }
    private static String read(InputStream is)throws IOException{ if(is==null)return ""; BufferedReader r=new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8)); StringBuilder b=new StringBuilder(); String s; while((s=r.readLine())!=null)b.append(s); return b.toString(); }
    public static String message(String body){ try{return new JSONObject(body).optString("message",body);}catch(Exception e){return body;} }
    public static String code(String body){ try{return new JSONObject(body).optString("code","");}catch(Exception e){return "";} }
}
