package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_BodyTekrarlardanKurtulma {

    /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){

        String url= "https://restful-booker.herokuapp.com/booking/1";

        Response response= given().when().get(url);
        response.prettyPrint();

         response.then().assertThat()
                 .statusCode(200)
                 .contentType(ContentType.JSON)
                 .body("firstname",Matchers.equalTo("Mary"),
                 "lastname",Matchers.equalTo("Brown"),
                         "totalprice",Matchers.equalTo(111),
                         "depositpaid",Matchers.equalTo(true),
                         "additionalneeds",Matchers.equalTo("Breakfast"));

    }
}
