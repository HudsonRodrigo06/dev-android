package junior.pedroso.rodrigo.appfragments.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

public class BaixaImagem extends AsyncTask<String,Integer, Bitmap>
{
    @Override
    public Bitmap doInBackground(String... strings) {
        Bitmap imagem=null;
        try
        {
            URL url=new URL(strings[0]);
            InputStream is=url.openStream();
            imagem = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch(Exception e)
        {
            imagem=null;
        }
        return imagem;
    }
}

