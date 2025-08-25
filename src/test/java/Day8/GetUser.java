package Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser {
    @Test
    public void getUser(ITestContext context){
        String id_value = (String) context.getAttribute("user_id");

        given()
                .pathParam("id_path",id_value)
                .when()
                .get("http://localhost:3000/students_details/{id_path}")
                .then()
                .log().all();
    }
}
