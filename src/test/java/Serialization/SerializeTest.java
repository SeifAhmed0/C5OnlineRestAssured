package Serialization;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SerializeTest {

    @Test
    public void convertTimeZoneJF(){
        TimeZoneRequest reqBody = new TimeZoneRequest();
        reqBody.setFromTimeZone("Africa/Cairo");
        reqBody.setToTimeZone("2026-07-29 21:20:00");
        reqBody.setDateTime("America/Los_Angeles");
        reqBody.setDstAmbiguity("");

        given().log().all()
                .baseUri("https://timeapi.io")
                .contentType("application/json")
                .body(reqBody)
                .when()
                .post("api/conversion/converttimezone")
                .then().log().all();
    }
}
