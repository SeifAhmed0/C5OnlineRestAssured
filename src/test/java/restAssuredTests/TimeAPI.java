package restAssuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TimeAPI {
    @Test
    public void convertTimeZone(){
        baseURI = "https://timeapi.io/api/";
        given().log().all()
        .header("Content-Type", "application/json")
        .body("{\n" +
                "    \"fromTimeZone\": \"Africa/Cairo\",\n" +
                "    \"dateTime\": \"2026-07-29 21:36:00\",\n" +
                "    \"toTimeZone\": \"America/Los_Angeles\",\n" +
                "    \"dstAmbiguity\": \"\"\n" +
                "}")
        .when()
        .post("conversion/converttimezone")
        .then().log().all()
        .statusCode(200)
        .header("Content-Type", containsString("json"))
        .time(lessThan(8000L))
        .body("fromTimezone", equalTo("Africa/Cairo"));
    }

    @Test
    public void convertTimeZoneStringBlock(){
        baseURI = "https://timeapi.io/api/";
        given().log().all()
                .header("Content-Type", "application/json")
                .body(TestData.getConversionData())
                .when()
                .post("conversion/converttimezone")
                .then().log().all()
                .statusCode(200)
                .header("Content-Type", containsString("json"))
                .time(lessThan(8000L))
                .body("fromTimezone", equalTo("Africa/Cairo"));
    }
}
