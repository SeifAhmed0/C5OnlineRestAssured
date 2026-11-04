package Example;

import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class TestSerializationExample {
    @Test
    public void testCaseReqRes(){
        C01_UserRequest userBody = new C01_UserRequest();
        userBody.setName("Mohamed");
        userBody.setJob("Software Test Engineer");
        userBody.setSkills(Arrays.asList("Java", "Selenium", "Rest Assured"));

        C03_Contact contact = new C03_Contact();
        contact.setEmail("Seif@example.com");
        contact.setPhone("0123456789");

        C02_Address address = new C02_Address();
        address.setCity("Cairo");
        address.setCountry("Egypt");

        given().log().all()
                .baseUri("https://reqres.in/")
                .contentType("application/json")
                .body(userBody)
                .when()
                .post("api/users")
                .then().log().all()
                .statusCode(201);

    }

}
