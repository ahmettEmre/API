package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerokuApp;

import static io.restassured.RestAssured.given;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuApp testDataHerokuApp=new TestDataHerokuApp();

        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",testDataHerokuApp.bookingJson());

        Response response = given().spec(specHerokuApp).when().post("/{pp1}");

        JsonPath respJP= response.jsonPath();






    }
}
