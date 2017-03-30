package com.julianyepes.copaturistica;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaFragment extends Fragment {

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.ic_info, R.drawable.copa_info, "Info del Municipio"),
            new Lista_Entrada(R.drawable.ic_simbolos,R.drawable.simbolos, "Simbolos"),
            new Lista_Entrada(R.drawable.ic_fiestas, R.drawable.fiestas_copa, "Fiestas"),
            new Lista_Entrada(R.drawable.ic_mapa, R.drawable.mapa_lista, "Ver Mapa")};

    ListView list;

    public listaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        list = (ListView) view.findViewById(R.id.list);


        Adapter adapter = new Adapter(getActivity().getBaseContext(), datos);
        //      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ( (Lista_Entrada)parent.getItemAtPosition(position)).getListText();
                Toast.makeText(getActivity().getBaseContext(), data,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity().getBaseContext(), MainNavigationDrawerActivity.class);
                intent.putExtra("fragment",( (Lista_Entrada)parent.getItemAtPosition(position)).getListText() );
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lista, container, false);
        return  view;
    }

    class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item, datos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView listaText = (TextView) item.findViewById(R.id.listText);
            listaText.setText(datos[position].getListText());

            ImageView idListaIcono = (ImageView) item.findViewById(R.id.listIcono);
            idListaIcono.setImageResource(datos[position].getIdListaIcono());

            LinearLayout idListaImg = (LinearLayout) item.findViewById(R.id.listImg);
            idListaImg.setBackgroundResource( datos[position].getIdListaImg());
            return item;
        }
    }

}
