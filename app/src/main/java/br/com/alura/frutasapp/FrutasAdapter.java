package br.com.alura.frutasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 14/07/2017.
 */

class FrutasAdapter extends BaseAdapter{

    private final List<Fruta> frutas;
    private final Context context;

    public FrutasAdapter(Context context, List<Fruta> frutas) {
        this.context = context;
        this.frutas = frutas;
    }

    @Override
    public int getCount() {
        return frutas.size();
    }

    @Override
    public Object getItem(int position) {
        return frutas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruta fruta = frutas.get(position);

        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        if(view == null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(fruta.getName());

        TextView campoPrice = (TextView) view.findViewById(R.id.item_preco);
        campoPrice.setText(String.valueOf(fruta.getPrice()));

//        ImageView campoFoto = (ImageView) view.findViewById(R.id.item_foto);
//        String caminhoFoto = aluno.getCaminhoFoto();
//        if(caminhoFoto != null){
//            Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(caminhoFoto));
//            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap,100,100,true);
//            campoFoto.setImageBitmap(bitmapReduzido);
//            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
        return view;
    }
}
