package com.herbalife.resource;

import com.herbalife.service.CalculatorService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@QuarkusIntegrationTest
public class CalculatorResourceIntegrationTest {

    @Test
    public void testSum() {
        when()
                .get("/calc/sum/1/1")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void testAddition() {
        given()
                .pathParam("a", 10)
                .pathParam("b", 20)
                .get("/calc/sum/{a}/{b}")
                .then()
                .statusCode(200)
                .body(is("30"));
    }


    @Test
    public void testSquare() {
        when()
                .get("/calc/square/2")
                .then()
                .statusCode(200)
                .body(is("4"));
    }
}
