package kjminn.kr.hs.emirim.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.551399,126.988151),17)); //값이 클수록 더 확대감 됨(20정도까지)
        //(*)moveCamera로 위치 바꿀 수 있음 원하는 위치의 위도 경도 입력해서!
        googleMap.getUiSettings().setZoomControlsEnabled(true); //setZoomControlsEnabled는 getUiSettings객체안에 들어있는 메소드임 => 확대,축소 버튼 설정
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"위성지도");
        menu.add(0,2,0,"일반지도");
        menu.add(0,3,0,"코엑스몰");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case 1:  googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case 2:  googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.513296, 127.057781),17));
                return true;
        }
        return false;
    }
}
