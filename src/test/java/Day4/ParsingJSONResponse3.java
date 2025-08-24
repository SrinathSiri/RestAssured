package Day4;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponse3 {
    @Test
    public void parsingJSONResponse(){
        Response res = given()
                .when()
                .get("http://localhost:3000/store");
        JSONObject jo = new JSONObject(res.asString());

        boolean status = false;

        for(int i=0;i<jo.getJSONArray("book").length();i++){
            String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            //ystem.out.println(booktitle);
            if(booktitle.equals("The lord of the Rings")){
                status = true;
                break;
            }
        }
        Assert.assertEquals(status,true);
        double totalprice = 0;
        for(int i=0;i<jo.getJSONArray("book").length();i++){
            String echprice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            double ecprice = Double.parseDouble(echprice);
            totalprice = totalprice+ecprice;
        }
        System.out.println("Total books price is : "+totalprice);
        Assert.assertEquals(totalprice,525.55);
    }
}