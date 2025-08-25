package Day7;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BasicAuth {
    @Test
    public void basicAuth(){

        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true))
        //.log().headers();
                //.log().cookies()
                .log().body();
    //.log().all();



    }
}
