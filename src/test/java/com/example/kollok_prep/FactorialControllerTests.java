package com.example.kollok_prep;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FactorialControllerTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080; // Убедитесь, что сервер работает на этом порту
    }

    @Test
    public void testGetFactorials_ValidInput() {
        given()
                .queryParam("n", 5)
                .when()
                .get("/api/factorials")
                .then()
                .statusCode(200)
                .body("$", hasSize(5))
                .body("[0]", equalTo(1))  // 0! = 1
                .body("[1]", equalTo(1))  // 1! = 1
                .body("[2]", equalTo(2))  // 2! = 2
                .body("[3]", equalTo(6))  // 3! = 6
                .body("[4]", equalTo(24)); // 4! = 24
    }

    @Test
    public void testGetFactorials_InvalidInput() {
        given()
                .queryParam("n", -1)
                .when()
                .get("/api/factorials")
                .then()
                .statusCode(400); // Ожидаем ошибку 400 Bad Request
    }

    @Test
    public void testGetFactorials_ZeroInput() {
        given()
                .queryParam("n", 0)
                .when()
                .get("/api/factorials")
                .then()
                .statusCode(400); // Ожидаем ошибку 400 Bad Request
    }
}