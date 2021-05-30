package junior.pedroso.rodrigo.appfragments.util;

import android.os.AsyncTask;

public class AcessaWSTask extends AsyncTask <String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        return junior.pedroso.rodrigo.appfragments.util.AcessaWS.consumir(strings[0]);
    }
}
