package Day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Cookie2 {
    @Test
    public void singleCookieResponseCapture(){
        Response res = given()

                .when()
                .get("https://www.google.com/");
                String AECvalue = res.getCookie("AEC");
                System.out.println("AEC cookie value is ---> "+AECvalue);
    }
}
