package com.ecommerce.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import static org.hamcrest.Matchers.equalTo;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
            {
                "id": "1",
                "name": "Whiskers",
                "race": "Siamese",
                "color": "Cream and Brown",
                "price": 150.00,
                "description": "A playful Siamese cat that loves to climb and explore.",
                "image": "https://example.com/images/whiskers.jpg"
            }
            """;

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", equalTo("Whiskers"))
				.body("race", equalTo("Siamese"))
				.body("color", equalTo("Cream and Brown"))
				.body("price", equalTo(150.00f))
				.body("description", equalTo("A playful Siamese cat that loves to climb and explore."))
				.body("image", equalTo("https://example.com/images/whiskers.jpg"));
	}
}