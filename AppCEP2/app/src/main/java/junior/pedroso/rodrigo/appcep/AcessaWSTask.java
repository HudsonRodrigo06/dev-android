package junior.pedroso.rodrigo.appcep;

import android.os.AsyncTask;

public class AcessaWSTask extends AsyncTask <String, Integer, String> {

    @Override
    protected String doInBackground(String... urls) {

        return AcessaWS.consumir(urls[0]);

    }
}
