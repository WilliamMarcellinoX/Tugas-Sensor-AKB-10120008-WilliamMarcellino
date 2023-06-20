package com.example.TugasSensorWilliam_10120008;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120008
// NAMA : William Marcellino
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.869093418571346, 107.53273714353132);
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Rumah Makan Padasuka");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.868276797833498, 107.5231890668458);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("RM Kiambang Raya");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.857470943184638, 107.53409819343807);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Seafood Abah Laut");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.862815005846729, 107.5294038106241);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("CK KULIKE Fried Chicken");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.860238978991225, 107.52555442687147);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Rumah Makan Tirta Mulya");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}