package Day2;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReqBodyJSONLib {
    @Test
    public void reqBodyJSONLib(){
        JSONObject data = new JSONObject();
        data.put("name","Trumph");
        data.put("location","USA");
        data.put("phone","123321123");
        String[] coursesarr = {"Microsoft","Google"};
        data.put("courses",coursesarr);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Trumph"))
                .body("courses[0]",equalTo("Microsoft"))
                .log().all();
    }
}
