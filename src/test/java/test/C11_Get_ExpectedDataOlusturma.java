package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        String url= "https://jsonplaceholder.typicode.com/posts/22";

        //Expected data hazirlama

        JSONObject expBody = new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response= given().when().get(url);
        response.prettyPrint();

        //Assertion

        JsonPath resJSPath = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),resJSPath.get("userId"));
        Assert.assertEquals(expBody.get("id"),resJSPath.get("id"));
        Assert.assertEquals(expBody.get("title"),resJSPath.get("title"));
        Assert.assertEquals(expBody.get("body"),resJSPath.get("body"));





    }

}
