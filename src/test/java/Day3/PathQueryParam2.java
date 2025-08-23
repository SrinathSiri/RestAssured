package Day3;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQueryParam2 {

    // Using X API Key

    @Test
    public void pathqueryparam(){
        given()
                .header("x-api-key","reqres-free-v1")
                .pathParam("mypath1","users")
                .queryParam("page",2)
                .queryParam("id",10)
                .when()
                .get("https://reqres.in/api/{mypath1}")
                .then()
                .log().all();
    }
}
