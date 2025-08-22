package Day2;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RequestBodyWays {

    @Test
    public void requestBodyWays(){
        HashMap obj = new HashMap();
        obj.put("name","Pavan");
        obj.put("location","Telangana");
        obj.put("phone","+91-9866448888");
        String[] coursesdata={"Selenium","RestAssured"};
        obj.put("courses",coursesdata);

        given()
                .contentType("application/json")
                .body(obj)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .body("name",equalTo("Pavan"))
                .body("location",equalTo("Telangana"))
                .body("courses[0]",equalTo("Selenium"))
                .body("courses[1]",equalTo("RestAssured"))
                .log().all();


    }

}
