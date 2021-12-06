package com.example.rojakrecycle.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rojakrecycle.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

public class MapActivity extends Fragment implements OnMapReadyCallback, GoogleMap.OnPoiClickListener {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.googleMap);
//    }

    GoogleMap map;

    private static View view;

    private LatLng targetLatLng = new LatLng(0,0);
    private String targetName = "";

    public MapActivity(LatLng targetLatLng, String targetName)
    {
        this.targetLatLng = targetLatLng;
        this.targetName = targetName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = View.inflate(getActivity(), R.layout.activity_map, null);
        } catch (InflateException e) {
            /* map is already there, just return view as it is */
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getActivity()
                .getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        map.addMarker(new MarkerOptions().position(targetLatLng).title(targetName));
        map.moveCamera(CameraUpdateFactory.newLatLng(targetLatLng));
        map.setOnPoiClickListener(this);
    }

    @Override
    public void onPoiClick(PointOfInterest poi) {
        Toast.makeText(getActivity(), "Clicked: " +
                        poi.name + "\nPlace ID:" + poi.placeId +
                        "\nLatitude:" + poi.latLng.latitude +
                        " Longitude:" + poi.latLng.longitude,
                Toast.LENGTH_SHORT).show();
    }
}