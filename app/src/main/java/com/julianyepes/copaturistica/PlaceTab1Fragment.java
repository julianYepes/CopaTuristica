package com.julianyepes.copaturistica;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceTab1Fragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private String places,lugar_descrip;
    double latitud, longitud;

    public PlaceTab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place_tab1, container, false);

        mapView = (MapView) rootView.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        TextView textView = (TextView) rootView.findViewById(R.id.tfPlace);
        TextView descri = (TextView) rootView.findViewById(R.id.tfDescri);
        ImageView foto = (ImageView) rootView.findViewById(R.id.ifFoto);
        LinearLayout contenedor = (LinearLayout) rootView.findViewById(R.id.lContenedor);

        int place = getArguments().getInt("place");
        places = getArguments().getString("places");

        switch ( places ){
            case "Deporte":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.deporte1));
                        descri.setText(getResources().getString(R.string.deporte1_descri));
                        foto.setImageResource(R.drawable.deporte12);

                        lugar_descrip = getResources().getString(R.string.deporte1);
                        longitud =  -75.516942;
                        latitud = 6.344997;
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.deporte2));
                        descri.setText(getResources().getString(R.string.deporte2_descri));
                        foto.setImageResource(R.drawable.deporte21);

                        lugar_descrip = getResources().getString(R.string.deporte2);
                        longitud =  -75.505698;
                        latitud = 6.341520;
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.deporte3));
                        descri.setText(getResources().getString(R.string.deporte3_descri));
                        foto.setImageResource(R.drawable.deporte3);

                        lugar_descrip = getResources().getString(R.string.deporte3);
                        longitud =  -75.504154;
                        latitud = 6.345125;
                        break;
                }

                break;
            case "Bares":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.bar1));
                        descri.setText(getResources().getString(R.string.bar1_descri));
                        foto.setImageResource(R.drawable.bar1);

                        lugar_descrip = getResources().getString(R.string.bar1);
                        longitud =  -75.506467;
                        latitud = 6.346532;
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.bar2));
                        descri.setText(getResources().getString(R.string.bar2_descri));
                        foto.setImageResource(R.drawable.bar2);

                        lugar_descrip = getResources().getString(R.string.bar2);
                        longitud =  -75.508851;
                        latitud = 6.346404;
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.bar3));
                        lugar_descrip = getResources().getString(R.string.bar3);
                        descri.setText(getResources().getString(R.string.bar3_descri));
                        foto.setImageResource(R.drawable.bar3);

                        lugar_descrip = getResources().getString(R.string.bar3);
                        longitud =  -75.494476;
                        latitud = 6.371675;
                        break;
                }
                break;
            case "SiteTour":
                switch (place){
                    case 1:
                        textView.setText(getResources().getString(R.string.site1));
                        foto.setImageResource(R.drawable.site1);
                        descri.setText(getResources().getString(R.string.site1_descri));

                        lugar_descrip = getResources().getString(R.string.site1);
                        longitud =  -75.500291;
                        latitud = 6.341680;
                        break;
                    case 2:
                        textView.setText(getResources().getString(R.string.site2));
                        descri.setText(getResources().getString(R.string.site2_descri));
                        foto.setImageResource(R.drawable.site2);

                        lugar_descrip = getResources().getString(R.string.site2);
                        longitud =  -75.485566;
                        latitud = 6.375995;
                        break;
                    case 3:
                        textView.setText(getResources().getString(R.string.site3));
                        descri.setText(getResources().getString(R.string.site3_descri));
                        foto.setImageResource(R.drawable.site3);

                        lugar_descrip = getResources().getString(R.string.site3);
                        longitud = -75.495472;
                        latitud = 6.355806;
                        break;
                }
                break;
        }

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        //mMap.setMapType(googleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng lugar = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().
                position(lugar).
                title(places).
                snippet(lugar_descrip));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 15));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}