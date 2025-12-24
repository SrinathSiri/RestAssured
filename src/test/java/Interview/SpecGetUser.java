package Interview;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class SpecGetUser {
    @Test
    public void getSingeUser() {
        // Disable SSL certificate verification
        useRelaxedHTTPSValidation();

        given()
                .spec(SpecBuilder.reqSpec())
                .when()
                    .get("/api/users/2")
                .then()
                    .spec(SpecBuilder.resSpec(200))
                    .log().all();
    }
}
