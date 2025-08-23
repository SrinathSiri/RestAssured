package Day3;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Header3 {
    @Test
    public void getAllHeaderValues(){
        Response res = given()
                .when()
                .get("https://www.google.com/");
        Headers multipleheaders = res.getHeaders();
        for(Header echeader:multipleheaders){
            System.out.println(echeader.getName()+" value is : "+echeader.getValue());
        }
    }
}
