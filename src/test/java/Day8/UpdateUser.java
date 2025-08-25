package Day8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    @Test
    public void updateUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("gender","Male");
        jo.put("phone",faker.phoneNumber().cellPhone());
        jo.put("email",faker.internet().safeEmailAddress());
        jo.put("status","Active");

        String id_value = (String) context.getAttribute("user_id");
        given()
                .contentType("application/json")
                .pathParam("id_path",id_value)
                .body(jo.toString())
                .when()
                .put("http://localhost:3000/students_details/{id_path}")
                .then()
                .log().all();
    }
}
