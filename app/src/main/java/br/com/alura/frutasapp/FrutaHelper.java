package br.com.alura.frutasapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.icu.text.StringPrepParseException;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 15/07/2017.
 */

public class FrutaHelper {

    private final TextView  campoNome;
    private final TextView  campoReal;
    private final TextView  campoDolar;
    //private final ImageView campoFoto;
    private final SmartImageView campoFoto;
    Double real;
    private Fruta fruta;

    public FrutaHelper(FrutaActivity activity){

        // pegando parâmetros do activity_formulario.xml;
        campoNome = (TextView) activity.findViewById(R.id.fruta_nome);
        campoReal = (TextView) activity.findViewById(R.id.fruta_preco_real);
        campoDolar = (TextView) activity.findViewById(R.id.fruta_preco_dolar);
        //campoFoto = (ImageView) activity.findViewById(R.id.fruta_image);
        campoFoto = (SmartImageView) activity.findViewById(R.id.fruta_image);
        fruta = new Fruta();
    }

    public void preencheInfo(Fruta fr) {

        campoNome.setText(fr.getName());
        campoDolar.setText(String.valueOf(fr.getPrice()));
        real = fr.getPrice() * 3.5;
        real = Double.valueOf(String.format(Locale.US,"%.2f", real));
        campoReal.setText(String.valueOf(real));
        
        Bitmap bitmap = BitmapFactory.decodeFile(fr.getImage());
        campoFoto.setImageBitmap(bitmap);
        campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        campoFoto.setImageUrl(fr.getImage());
        this.fruta = fr;
    }

}
