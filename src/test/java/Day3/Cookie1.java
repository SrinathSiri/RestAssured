package Day3;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Cookie1 {
    @Test
    public void cookieValidation(){
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .cookie("AEC","AVh_V2ipCvhCfnK73kKEwJ8ysACMVLKBrIKbjoYQEj_8mrjuV7Cyvv-6xw")
                .log().all();
    }
}
