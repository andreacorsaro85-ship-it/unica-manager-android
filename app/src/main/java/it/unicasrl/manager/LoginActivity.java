package it.unicasrl.manager;

import android.app.*; import android.os.*; import android.content.*; import android.text.InputType; import android.widget.*; import org.json.*;

public class LoginActivity extends Activity {
    @Override public void onCreate(Bundle b){ super.onCreate(b); LinearLayout p=Ui.page(this); p.addView(Ui.title(this,"Accedi a UNICA")); p.addView(Ui.text(this,"Usa le stesse credenziali del gestionale. Se il tuo account richiede Google Authenticator, inserisci anche il codice a 6 cifre."));
        EditText login=Ui.input(this,"Email o username"); EditText pass=Ui.input(this,"Password"); pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD); EditText totp=Ui.input(this,"Codice Authenticator (se richiesto)"); totp.setInputType(InputType.TYPE_CLASS_NUMBER); Button go=Ui.button(this,"Accedi"); TextView status=Ui.text(this,""); p.addView(login);p.addView(pass);p.addView(totp);p.addView(go); Button privacy=Ui.button(this,"Privacy"); p.addView(privacy); p.addView(status); setContentView(p); privacy.setOnClickListener(v->startActivity(new Intent(this,PrivacyActivity.class)));
        go.setOnClickListener(v->{ go.setEnabled(false); status.setText("Verifica in corso…"); try{ JSONObject j=new JSONObject(); j.put("login",login.getText().toString().trim());j.put("password",pass.getText().toString());j.put("totp",totp.getText().toString().trim());j.put("device_name","Android "+android.os.Build.MODEL); Api.post(this,"/mobile/login",j,(code,body,e)->{ go.setEnabled(true); if(e!=null){status.setText("Connessione non riuscita: "+e.getMessage());return;} if(code>=200&&code<300){ try{String token=new JSONObject(body).getString("token");Prefs.token(this,token);startActivity(new Intent(this,MainActivity.class));finish();}catch(Exception x){status.setText("Risposta non valida.");} } else status.setText(Api.message(body)); }); }catch(Exception e){go.setEnabled(true);} });
    }
}
