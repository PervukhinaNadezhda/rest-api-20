package in.reqres;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;

public class TestBase {
    @BeforeAll
    static void baseURL() {
        baseURI = "https://reqres.in/api";
    }
}
