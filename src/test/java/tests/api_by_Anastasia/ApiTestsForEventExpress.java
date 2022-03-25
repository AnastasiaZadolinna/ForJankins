package tests.api_by_Anastasia;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTestsForEventExpress {

    @BeforeAll
    public static void setup() {

        baseURI = "https://eventsexpress-test.azurewebsites.net/";
    }

    /**
     * Tests for CategoryGroupAll
     */
    @Test
    public void verifyThatTitleContainsArtAndCraftInCategoryGroupAll() {
        CategoryGroup[] categories = given()
                .when()
                .contentType(ContentType.JSON)
                .get("api/CategoryGroup/All")
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .extract().as(CategoryGroup[].class);
        boolean containedValue = Arrays.stream(categories).anyMatch((element -> element.getTitle().equals("Art&Craft")));
        assertTrue(containedValue);
    }

    /**
     * Test for CategoryGroupById
     * Id = 88b791a5-6ce3-4b50-80ae-65572991f676
     */
    @Test
    public void verifyStatusCodeAndThatTitleAndIdContainsValidValues() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("api/CategoryGroup/Get/88b791a5-6ce3-4b50-80ae-65572991f676")
                .then()
                .assertThat().statusCode(200)
                .and()
                .body("title", is("Art&Craft"))
                .and()
                .body("id", is("88b791a5-6ce3-4b50-80ae-65572991f676"));
    }

    @Test
    public void unSuccessRegisteredTest() {
        Register user = new Register("user@example.com", "string");
        Map<String, List<String>> unSuccessRegs =
                given()
                        .body(user)
                        .when()
                        .contentType(ContentType.JSON)
                        .post("api/Authentication/RegisterBegin")
                        .then().log().all()
                        .assertThat().statusCode(400)
                        .and()
                        .extract().path("errors");
        assertEquals("This email is already in use", unSuccessRegs.get("_error").get(0));
    }

    @ParameterizedTest
    @MethodSource("unSuccessRegistered")
    void isUnSuccessRegisteredTest(String email, String errorField, String errorMessage) {
        Register user = new Register(email, "string");
        Map<String, List<String>> unSuccessRegs =
                given()
                        .body(user)
                        .when()
                        .contentType(ContentType.JSON)
                        .post("api/Authentication/RegisterBegin")
                        .then().log().all()
                        .assertThat().statusCode(400)
                        .and()
                        .extract().path("errors");
        assertEquals(errorMessage, unSuccessRegs.get(errorField).get(0), "");
    }

    private static Stream<Arguments> unSuccessRegistered() {
        return Stream.of(
                Arguments.of("user@example.com", "_error", "This email is already in use"),
                Arguments.of("userexample.com", "email", "Email Address is not correct")
        );
    }

    @Test
    public void emptyPasswordFieldError() {
        Register user = new Register("user@example.com", "");
        Map<String, List<String>> unSuccessRegs =
                given()
                        .body(user)
                        .when()
                        .contentType(ContentType.JSON)
                        .post("api/Authentication/RegisterBegin")
                        .then().log().all()
                        .assertThat().statusCode(400)
                        .and()
                        .extract().path("errors");
        assertEquals("Password is required", unSuccessRegs.get("password").get(0));
    }
}

