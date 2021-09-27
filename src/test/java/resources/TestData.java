package resources;

import pojo.AddAPlace;
import pojo.location;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public AddAPlace addPlace(String name, String add, String language){
        AddAPlace ap = new AddAPlace();
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.435353);

        ap.setLocation(l);
        ap.setAccuracy(60);
        ap.setName(name);
        ap.setPhone_number("9175610897");
        ap.setAddress(add);
        List<String> list = Arrays.asList("shop", "shoe market");
        ap.setTypes(list);
        ap.setWebsite("http://google.com");
        ap.setLanguage(language);

        return ap;
    }
}
