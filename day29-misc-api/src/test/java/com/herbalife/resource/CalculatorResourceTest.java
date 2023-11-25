package com.herbalife.resource;

import com.herbalife.service.CalculatorService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@QuarkusTest
@TestHTTPEndpoint(CalculatorResource.class)
public class CalculatorResourceTest {

    @InjectMock
    CalculatorService calculatorService;

    @Test
    public void testSum() {
        when(calculatorService.sum(1, 1)).thenReturn(2);
        when()
                .get("/sum/1/1")
                .then()
                .statusCode(200)
                .body(is("2"));
        verify(calculatorService, times(1)).sum(1, 1);
    }

    @Test
    public void testAddition() {
        when(calculatorService.sum(10, 20)).thenReturn(30);
        given()
                .pathParam("a", 10)
                .pathParam("b", 20)
                .get("/sum/{a}/{b}")
                .then()
                .statusCode(200)
                .body(is("30"));
        verify(calculatorService, times(1)).sum(10, 20);
    }


    @Test
    public void testSquare() {
        when(calculatorService.square(2)).thenReturn(4);
        when()
                .get("/square/2")
                .then()
                .statusCode(200)
                .body(is("4"));
        verify(calculatorService, times(1)).square(2);
    }
}
