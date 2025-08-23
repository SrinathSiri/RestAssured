package Day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Header2 {
    @Test
    public void getHeaderValues(){
        //capture header value and print

        Response res = given()
                .when()
                .get("https://www.google.com/");
        String contenttypevalue = res.getHeader("Content-Type");
        System.out.println("content-type value is : "+contenttypevalue);
    }
}
