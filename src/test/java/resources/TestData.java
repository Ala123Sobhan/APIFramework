package resources;

import pojo.AddAPlace;
import pojo.location;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public AddAPlace addPlace(){
        AddAPlace ap = new AddAPlace();
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.435353);

        ap.setLocation(l);
        ap.setAccuracy(60);
        ap.setName("1567 metro north bookiyklo");
        ap.setPhone_number("9175610897");
        ap.setAddress("28, side layout boo");
        List<String> list = Arrays.asList("shop", "shoe market");
        ap.setTypes(list);
        ap.setWebsite("http://google.com");
        ap.setLanguage("Bengali");

        return ap;
    }
}
