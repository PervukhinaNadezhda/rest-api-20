package in.reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ApiTest extends TestBase {

    @Test
    void getSingleUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/users/5")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(5));
    }

    @Test
    void getSingleUserNotFoundTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/users/25")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    @Test
    void postCreateUserTest() {
        String user = "{ \"name\": \"morpheus\", \"job\": \"leader\" }"; // BAD PRACTICE
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"));
    }

    @Test
    void putUpdateUserTest() {
        String user = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }"; // BAD PRACTICE
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(user)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    void deleteUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
    
}
