package restAssuredTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Correlation {
    @Test
    public void verifyTimeZoneConversion(){
        baseURI = "https://timeapi.io/";
        Response response = given().log().all()
                .queryParam("timeZone","Africa/Cairo")
                .header("Accept", "application/json")
                .when()
                .get("api/v1/timezone/zone")
                .then().log().all()
                .statusCode(200)
                .body("timezone", equalTo("Africa/Cairo"))
                .body("local_time", notNullValue())
                .extract().response();

        String fromTimeZone = response.jsonPath().getString("timezone");
        String dateTimee = response.jsonPath().getString("local_time");
        System.out.println(fromTimeZone);
        System.out.println(dateTimee);
        String dateTime = dateTimee.substring(0,19).replace("T"," ");
        System.out.println(dateTime);
        System.out.println("===========================================");


        //Request of the other API
        Response response1 = given().log().all()
                .baseUri("https://timeapi.io/")
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(TestData.getConversionDataCorrelated(fromTimeZone, dateTime))
                .when()
                .post("api/conversion/converttimezone")
                .then().log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .extract().response();
    }
}
