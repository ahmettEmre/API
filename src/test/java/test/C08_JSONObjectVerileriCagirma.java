package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {

    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */

    @Test
    public void jsonPath01(){

        JSONObject cepTel=new JSONObject();
        cepTel.put("type","iphone");
        cepTel.put("type","0123-4567-8888");

        JSONObject evTel=new JSONObject();
        evTel.put("type","home");
        evTel.put("type","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(1,evTel);
        phoneNumbers.put(0,cepTel);

        JSONObject addresses=new JSONObject();
        addresses.put("streetAddress","naist street");
        addresses.put("city","Nara");
        addresses.put("postalCode","630-0192");

        JSONObject kisiBilgisi = new JSONObject();
        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","Doe");
        kisiBilgisi.put("age","26");
        kisiBilgisi.put("address",addresses);
        kisiBilgisi.put("phone Numbers",phoneNumbers);

        System.out.println("kisi bilgisi: " + kisiBilgisi);


    }
}
