package Day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReqBodyExtJSON {

    @Test
    public void reqBodyExternalJSONFile() throws FileNotFoundException {

        File file = new File(".\\jsondata\\payload.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(jo.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("N MODI"))
                .body("courses[0]",equalTo("IndiaHistory"))
                .log().all();
    }
}
