package junior.pedroso.rodrigo.appgetrandomuser.util;

import android.os.AsyncTask;

public class AcessaWSTask extends AsyncTask <String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        return AcessaWS.consumir(strings[0]);
    }
}
