package Day3;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LogInfo {
    @Test
    public void logInfo(){
        given()
                .when()
                .get("http://localhost:3000/students")
                .then()
                //.log().headers();
                //.log().cookies();
                //.log().body();
                .log().all();

    }
}
