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

        mMap.setMapType(googleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng udea = new LatLng(6.266953, -75.569111);
        mMap.addMarker(new MarkerOptions().
                position(udea).
                title("UdeA").
                snippet("Nuestra Alma Mater"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea, 10));
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