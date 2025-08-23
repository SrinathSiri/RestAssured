package Day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Cookie3 {
    @Test
    public void getCookiesValues(){
        Response res = given()
                .when()
                .get("https://www.google.com/");
    Map<String,String> cookiesobj = res.getCookies();
    Set<String> keys = cookiesobj.keySet();
    for(String eckey:keys){
        String cookievalue = res.getCookie(eckey);
        System.out.println(eckey+" value is : "+cookievalue);
    }
}
}
