package testData;

import org.json.JSONObject;

public class TestDataHerokuApp {

    public int basariliStatusKod= 200;

    public JSONObject bookingDatesJson(){
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");
        return bookingdates;
    }

    public JSONObject bookingJson(){
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingDatesJson());
        reqBody.put("additionalneeds","wi-fi");
        return reqBody;
    }
}
