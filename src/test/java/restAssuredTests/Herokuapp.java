package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Herokuapp {
    @Test
    public void validateUser(){
        baseURI = "https://reqres.in/api/";
        given().log().all()
        .when()
        .get("users/2")
        .then().log().all()
        .statusCode(200)
        .body("data.id", equalTo(2))
        .body("data.first_name", equalTo("Janet"))
        .body("_meta.powered_by", equalTo("ReqRes"));
    }
}
