package Day7;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class OAUTH2Auth {
    @Test
    public void oauth2Auth(){
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .log().all();
    }

}
