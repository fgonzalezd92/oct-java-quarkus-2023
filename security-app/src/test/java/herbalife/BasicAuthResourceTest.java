package herbalife;

import com.herbalife.BasicAuthResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(BasicAuthResource.class)
public class BasicAuthResourceTest {

    @Test
    public void testSample() {
        given()
                .when().get("/sample")
                .then()
                .statusCode(200);
        //.body(is("Please login!"));
    }
}
