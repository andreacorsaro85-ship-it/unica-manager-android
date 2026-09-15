package it.unicasrl.manager;

import android.app.*;
import android.os.*;
import android.content.*;
import android.net.Uri;
import android.widget.*;

public class PrivacyActivity extends Activity {
    @Override public void onCreate(Bundle b){
        super.onCreate(b);
        LinearLayout p=Ui.page(this);
        p.addView(Ui.title(this,"Privacy e dati personali"));
        p.addView(Ui.text(this,
            "UNICA Manager utilizza i dati necessari per l'accesso al gestionale e per le funzioni operative autorizzate. " +
            "La posizione precisa viene richiesta esclusivamente quando avvii o termini un lavoro, per verificare la presenza presso la sede dell'incarico. " +
            "L'app non effettua tracciamento continuo della posizione."));
        Button open=Ui.button(this,"Leggi l'informativa privacy completa");
        p.addView(open);
        open.setOnClickListener(v->{
            String base=Prefs.base(this);
            if(base==null||base.trim().isEmpty()){
                Toast.makeText(this,"Configura prima l'indirizzo del gestionale.",Toast.LENGTH_LONG).show();
                return;
            }
            String url=base.replaceAll("/+$","")+"/privacy-unica-manager/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        setContentView(p);
    }
}
