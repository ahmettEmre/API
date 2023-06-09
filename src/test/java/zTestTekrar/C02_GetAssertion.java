package zTestTekrar;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetAssertion {


    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/

    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response= given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType("application/json; charset=utf-8");
        response.then().assertThat().header("Server","Cowboy");
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

    }
}
