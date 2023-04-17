package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */
    @Test
    public void jsonObje01(){

        JSONObject jsonObject=new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId","1");

        System.out.println("JsonObject= "+jsonObject);

    }

    @Test
    public void jsonObje02(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject ilkJsonObject=new JSONObject();
        JSONObject bookingDates=new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        ilkJsonObject.put("firstname","Jim");
        ilkJsonObject.put("additionalneeds","Breakfast");
        ilkJsonObject.put("bookingdates",bookingDates);
        ilkJsonObject.put("totalprice","111");
        ilkJsonObject.put("depositpaid","true");
        ilkJsonObject.put("lastname","Brown");

        System.out.println("JsonObject= "+ilkJsonObject);
    }
}
