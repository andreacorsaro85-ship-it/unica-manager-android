package it.unicasrl.manager;

import android.content.Context;
import android.content.SharedPreferences;

public final class Prefs {
    private static final String P = "unica";
    public static String base(Context c){ return c.getSharedPreferences(P,0).getString("base",""); }
    public static void base(Context c,String v){ c.getSharedPreferences(P,0).edit().putString("base",v).apply(); }
    public static String token(Context c){ return c.getSharedPreferences(P,0).getString("token",""); }
    public static void token(Context c,String v){ c.getSharedPreferences(P,0).edit().putString("token",v).apply(); }
    public static void clearToken(Context c){ token(c,""); }
    public static boolean locationDisclosureAccepted(Context c){ return c.getSharedPreferences(P,0).getBoolean("location_disclosure_accepted",false); }
    public static void locationDisclosureAccepted(Context c,boolean v){ c.getSharedPreferences(P,0).edit().putBoolean("location_disclosure_accepted",v).apply(); }
}
