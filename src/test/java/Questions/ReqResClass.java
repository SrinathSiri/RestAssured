package Questions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReqResClass {
    @Test
    public void reqresmethod(){
        given()
                .spec(SpecBuilder.reqSpec())
                .when()
                .get("/projects/projectid")
                .then()
                .spec(SpecBuilder.resSpec());
    }
}
