package com.julianyepes.copaturistica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        int place = getArguments().getInt("place");
        String places = getArguments().getString("places");

        switch ( places ){
            case "Hotels":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.hotel1));
                        textView.setBackgroundResource(R.drawable.hotel1);
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.hotel2));
                        textView.setBackgroundResource(R.drawable.hotel2);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.hotel3));
                        textView.setBackgroundResource(R.drawable.hotel3);
                        break;
                }

                break;
            case "Bares":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.bar1));
                        textView.setBackgroundResource(R.drawable.bar1);
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.bar2));
                        textView.setBackgroundResource(R.drawable.bar2);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.bar3));
                        textView.setBackgroundResource(R.drawable.bar3);
                        break;
                }
                break;
            case "SiteTour":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.site1));
                        textView.setBackgroundResource(R.drawable.site1);
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.site2));
                        textView.setBackgroundResource(R.drawable.site2);
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.site3));
                        textView.setBackgroundResource(R.drawable.site3);
                        break;
                }
                break;
        }

        return rootView;
    }

}
