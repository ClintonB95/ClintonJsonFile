package com.example.robpercival.jsondemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import javax.crypto.spec.GCMParameterSpec;

import static android.location.LocationManager.GPS_PROVIDER;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    LocationManager LocationManager;
    LocationListener LocationListener;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                LocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, LocationListener);
            }
        }
    }



    public static ArrayList<Double> Lat = new ArrayList<Double>();
    public static ArrayList<Double> lng = new ArrayList<Double>();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera

        LocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                LatLng Dublin = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(Dublin).title("Dublin City Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dublin, 15));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (Build.VERSION.SDK_INT < 23) {
            LocationManager.requestLocationUpdates(GPS_PROVIDER, 0, 0, LocationListener);
        }
        else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new  String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);

                Location lastknownLocation = LocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                LatLng Dublin = new LatLng(lastknownLocation.getLatitude(), lastknownLocation.getLongitude());
                mMap.addMarker(new MarkerOptions().position(Dublin).title("Dublin City Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dublin, 15));
            }
        }


        Intent intent = getIntent();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        LatLng Dublin = new LatLng(53.3512448, -6.2629676);
        mMap.addMarker(new MarkerOptions().position(Dublin).title("Dublin City Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dublin, 15));
        LatLng Dublin1 = new LatLng(53.349562, -6.278198);
        mMap.addMarker(new MarkerOptions().position(Dublin1).title("CLONMEL STREET").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin2 = new LatLng(53.353462,  -6.265305);
        mMap.addMarker(new MarkerOptions().position(Dublin2).title("MOUNT STREET LOWER").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin3 = new LatLng(53.336021,  -6.26298);
        mMap.addMarker(new MarkerOptions().position(Dublin3).title("CHRISTCHURCH PLACE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin4 = new LatLng(53.33796,  -6.24153);
        mMap.addMarker(new MarkerOptions().position(Dublin4).title("GRANTHAM STREET").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin5 = new LatLng(53.343368,  -6.27012);
        mMap.addMarker(new MarkerOptions().position(Dublin5).title("PEARSE STREET").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin6 = new LatLng(53.334123,  -6.265436);
        mMap.addMarker(new MarkerOptions().position(Dublin6).title("YORK STREET EAST").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin7 = new LatLng(53.344304,  -6.250427);
        mMap.addMarker(new MarkerOptions().position(Dublin7).title("EXCISE WALK").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Dublin8 = new LatLng(53.338755,  -6.262003);
        mMap.addMarker(new MarkerOptions().position(Dublin8).title("FITZWILLIAM SQUARE WEST").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));





    }
}
