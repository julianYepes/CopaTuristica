package com.julianyepes.copaturistica;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listActivity extends AppCompatActivity {

    //String[] parques = new String[]{"Bolivar","la libertad","el lago","la rebeca"};
    private  Lista_Entrada[] datos = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.parque_principal,"parque 1", "descripcion 1","Cra # 1"),
            new Lista_Entrada(R.drawable.copa_parque,"parque 2", "descripcion 2","Cra # 2"),
            new Lista_Entrada(R.drawable.copa_cruz2,"parque 3", "descripcion 3","Cra # 3"),
            new Lista_Entrada(R.drawable.copacabana,"parque 4", "descripcion 4","Cra # 4")
    };
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.list);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parques);
        //list.setAdapter(adapter);

        Adapter adapter = new Adapter(this,datos);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(listActivity.this,  data, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(listActivity.this , PlacesTabActivity.class);
                startActivity(intent);
            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item,datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direccion = (TextView) item.findViewById(R.id.tDirecion);
            direccion.setText(datos[position].getDirec());

            ImageView foto = (ImageView) item.findViewById(R.id.iFoto);
            foto.setImageResource(datos[position].getIdImagen());

            return item;
            //return super.getView(position, convertView, parent);
        }
    }
}
