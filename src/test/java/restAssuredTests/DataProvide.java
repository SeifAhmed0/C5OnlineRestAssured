package restAssuredTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DataProvide {
    @DataProvider(name = "TimeZones")
    public Object[][] timezones(){
        return new Object[][]{
            {"Africa/Cairo"},
            {"Europe/London"},
            {"America/New_York"}
        };
    }

    @Test(dataProvider = "TimeZones")
    public void verifyTimeZone(String timezone){
        given().log().all()
                .baseUri("https://timeapi.io")
                .header("Accept", "application/json")
                .queryParam("timeZone", timezone)
                .when()
                .get("/api/timezone/zone")
                .then().log().all()
                .statusCode(200)
                .body("timeZone", equalTo(timezone))
                .body("currentLocalTime", notNullValue());
    }

    @Test
    public void convertTimeZoneJF(){
        File jsonFile = new File("src/main/resources/TestData/timezone.json");
        given().log().all()
                .baseUri("https://timeapi.io")
                .contentType("application/json")
                .body(jsonFile)
                .when()
                .post("api/conversion/converttimezone")
                .then().log().all();
    }
}
