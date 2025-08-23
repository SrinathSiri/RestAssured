package Day4;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponse2 {

    @Test
    public void parseJSONResponse(){
        Response res = given()
                .when()
                .get("http://localhost:3000/store");
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json");
        String book3title = res.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(book3title,"The lord of the Rings");

    }
}
