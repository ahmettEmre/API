package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expBody= new JSONObject();
        expBody.put("status","success");
        expBody.put("message","Successfully! Record has been fetched.");
        expBody.put("data",data);
        System.out.println("expBody : "+ expBody);

        Response response=given().when().get(url);

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(jsonPath.get("status"),expBody.get("status"));
        softAssert.assertEquals(jsonPath.get("message"),expBody.get("message"));
        softAssert.assertEquals(jsonPath.get("data.id"),expBody.getJSONObject("data").get("id"));

        softAssert.assertAll();







}
}
