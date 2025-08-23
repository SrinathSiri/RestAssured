package Day4;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponse1 {
    @Test
    public void parsingJSONResponse1(){
        given()
                .when()
                .get("http://localhost:3000/store")
                .then()
                .body("book[3].title",equalTo("The lord of the Rings"));
    }
}
