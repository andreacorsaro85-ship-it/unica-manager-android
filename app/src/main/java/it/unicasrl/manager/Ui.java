package it.unicasrl.manager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.*;

public final class Ui {
    public static final int GREEN = Color.rgb(18,60,44);
    public static final int GOLD = Color.rgb(180,151,90);
    public static int dp(Context c,int n){ return (int)(n*c.getResources().getDisplayMetrics().density+0.5f); }
    public static LinearLayout page(Context c){ LinearLayout l=new LinearLayout(c); l.setOrientation(LinearLayout.VERTICAL); l.setPadding(dp(c,20),dp(c,24),dp(c,20),dp(c,24)); l.setBackgroundColor(Color.rgb(247,249,248)); return l; }
    public static TextView title(Context c,String s){ TextView v=new TextView(c); v.setText(s); v.setTextSize(28); v.setTextColor(GREEN); v.setTypeface(Typeface.DEFAULT,Typeface.BOLD); v.setPadding(0,0,0,dp(c,16)); return v; }
    public static TextView text(Context c,String s){ TextView v=new TextView(c); v.setText(s); v.setTextSize(16); v.setTextColor(Color.rgb(45,57,52)); v.setPadding(0,dp(c,5),0,dp(c,5)); return v; }
    public static EditText input(Context c,String hint){ EditText e=new EditText(c); e.setHint(hint); e.setTextSize(16); e.setPadding(dp(c,12),dp(c,12),dp(c,12),dp(c,12)); e.setBackgroundColor(Color.WHITE); LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2); p.setMargins(0,0,0,dp(c,12)); e.setLayoutParams(p); return e; }
    public static Button button(Context c,String s){ Button b=new Button(c); b.setText(s); b.setTextColor(Color.WHITE); b.setTextSize(16); b.setBackgroundColor(GREEN); LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,dp(c,52)); p.setMargins(0,dp(c,8),0,dp(c,8)); b.setLayoutParams(p); return b; }
    public static View divider(Context c){ View v=new View(c); v.setBackgroundColor(Color.rgb(220,226,223)); v.setLayoutParams(new LinearLayout.LayoutParams(-1,dp(c,1))); return v; }
}
