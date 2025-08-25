package Day7;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BearerAuth {
    @Test
    public void bearerAuth(){
        given()
                .headers("Authorization","Bearer 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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }
}
