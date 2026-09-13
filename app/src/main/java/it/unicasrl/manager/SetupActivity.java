package it.unicasrl.manager;

import android.app.*; import android.os.*; import android.content.*; import android.text.InputType; import android.widget.*;

public class SetupActivity extends Activity {
    @Override public void onCreate(Bundle b){ super.onCreate(b); if(!Prefs.base(this).isEmpty()){ next(); return; }
        LinearLayout p=Ui.page(this); p.addView(Ui.title(this,"UNICA Manager")); p.addView(Ui.text(this,"Prima configurazione. Inserisci l'indirizzo HTTPS del gestionale aziendale. Esempio: https://gestionale.tuodominio.it"));
        EditText url=Ui.input(this,"https://..."); url.setInputType(InputType.TYPE_TEXT_VARIATION_URI); p.addView(url); Button save=Ui.button(this,"Salva e continua"); p.addView(save); setContentView(p);
        save.setOnClickListener(v->{ String s=url.getText().toString().trim(); if(!s.startsWith("https://")){ Toast.makeText(this,"Per sicurezza è richiesto HTTPS.",Toast.LENGTH_LONG).show(); return;} while(s.endsWith("/"))s=s.substring(0,s.length()-1); Prefs.base(this,s); next(); });
    }
    private void next(){ startActivity(new Intent(this, Prefs.token(this).isEmpty()?LoginActivity.class:MainActivity.class)); finish(); }
}
