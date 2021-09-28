package stepDef;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeDeleteScenario() throws Throwable {

        addPlace ap = new addPlace();
        if(addPlace.placeID == null)
        {
            ap.add_place_payload_with_and("Pompeo","198 Bulevard", "Spanish");
            ap.user_calls_something_with_something_http_request("AddPlaceAPI", "Post");
            ap.the_something_maps_to_the_when_user_calls_something("place_id", "Pompeo", "getPlaceAPI" );



        }

    }
}
