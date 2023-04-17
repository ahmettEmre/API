package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */

    @Test
    public void post01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstname","Ahmet");
        jsonObject.put("lastname","Bulut");
        jsonObject.put("totalprice",500);
        jsonObject.put("depositpaid",false);
        jsonObject.put("bookingdates",bookingDates);
        jsonObject.put("additionalneeds","wi-fi");

        System.out.println(jsonObject);

        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",jsonObject);

        System.out.println(expBody);

        Response response = given().contentType(ContentType.JSON).when().body(jsonObject.toString()).post(url);

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),jsonPath.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),jsonPath.get("booking.lastname"));

    }
}
