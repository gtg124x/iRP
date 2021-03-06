package team1.gatech.edu.irp.controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationServiceFacade;

import java.util.List;


/**
 * Map Activity Screen
 *
 * @author Mitchell_Alvarado
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if(mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
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

        googleMap.getUiSettings().setZoomControlsEnabled(true);

        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();

        List<Location> locations = getLocations(locationServiceFacade);
        for (Location l : locations) {

            List<String> nameAndPhoneNumber = l.getNameAndPhoneNumber();
            String name = nameAndPhoneNumber.get(0);
            String phone = nameAndPhoneNumber.get(1);

            List<Double> latitudeAndLongitude = l.getLatitudeAndLongitude();
            Double latitude = latitudeAndLongitude.get(0);
            Double longitude = latitudeAndLongitude.get(1);

            LatLng marker = new LatLng(latitude, longitude);
            googleMap.addMarker(new MarkerOptions().position(marker).title(name).snippet(
                    "Phone Number: " + phone));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        }
    }

    /**
     * gets the list of locations
     *
     * @param locationServiceFacade the locationServiceFacade
     * @return list of locations
     */
    private List<Location> getLocations(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocations();
    }


}
