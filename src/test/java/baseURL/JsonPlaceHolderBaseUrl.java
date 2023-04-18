package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    //https://jsonplaceholder.typicode.com

    protected RequestSpecification specJsonPlace;

    @Before
    public void setup01(){
        specJsonPlace=new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }
}
