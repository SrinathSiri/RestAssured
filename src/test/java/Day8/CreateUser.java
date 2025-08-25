package Day8;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUser {
    @Test
    public void createUser(ITestContext context){

        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("gender","Male");
        jo.put("phone",faker.phoneNumber().cellPhone());
        jo.put("email",faker.internet().safeEmailAddress());
        jo.put("status","In Active");

        Response res = given()
                .contentType("application/json")
                .body(jo.toString())
                .when()
                .post("http://localhost:3000/students_details");
        String newid = res.jsonPath().get("id");
        context.setAttribute("user_id",newid);

    }
}
