package com.julianyepes.copaturistica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceTab1Fragment extends Fragment {


    public PlaceTab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place_tab1, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tfPlace);
        TextView descri = (TextView) rootView.findViewById(R.id.tfDescri);
        ImageView foto = (ImageView) rootView.findViewById(R.id.ifFoto);
        LinearLayout contenedor = (LinearLayout) rootView.findViewById(R.id.lContenedor);

        int place = getArguments().getInt("place");
        String places = getArguments().getString("places");

        switch ( places ){
            case "Deporte":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.deporte1));
                        descri.setText(getResources().getString(R.string.deporte1_descri));
                        foto.setImageResource(R.drawable.deporte12);
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.deporte2));
                        descri.setText(getResources().getString(R.string.deporte2_descri));
                        foto.setImageResource(R.drawable.deporte21);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.deporte3));
                        descri.setText(getResources().getString(R.string.deporte3_descri));
                        foto.setImageResource(R.drawable.deporte3);
                        break;
                }

                break;
            case "Bares":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.bar1));
                        descri.setText(getResources().getString(R.string.bar1_descri));
                        foto.setImageResource(R.drawable.bar1);
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.bar2));
                        descri.setText(getResources().getString(R.string.bar2_descri));
                        foto.setImageResource(R.drawable.bar2);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.bar3));
                        descri.setText(getResources().getString(R.string.bar3_descri));
                        foto.setImageResource(R.drawable.bar3);
                        break;
                }
                break;
            case "SiteTour":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.site1));
                        foto.setImageResource(R.drawable.site1);
                        descri.setText(getResources().getString(R.string.site1_descri));
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.site2));
                        descri.setText(getResources().getString(R.string.site2_descri));
                        foto.setImageResource(R.drawable.site2);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.site3));
                        descri.setText(getResources().getString(R.string.site3_descri));
                        foto.setImageResource(R.drawable.site3);
                        break;
                }
                break;
        }

        return rootView;
    }

}
