package com.pgr301.exam

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.concurrent.TimeUnit
@ExtendWith(SpringExtension::class)

@SpringBootTest(classes = [(ExamApplication::class)], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExamApplicationTests {

    @LocalServerPort
    protected var port = 0

    @Test
    fun shouldCreateDevice() {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = port

        given().header("Content-Type", "application/json")
                .body("{ \"name\": \"test\", \"owner\": \"foo\"}")
                .post("http://localhost:$port/devices")
                .then().statusCode(201)
    }

}
