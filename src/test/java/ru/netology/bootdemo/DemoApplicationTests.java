package ru.netology.bootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Container
	private  final GenericContainer<?> myApp1 = new GenericContainer<>("prodapp:latest")
			.withExposedPorts(8080);
	@Container
	private  final GenericContainer<?> myApp2 = new GenericContainer<>("devapp:latest")
			.withExposedPorts(8080);

	@Test
	void contextLoads() {
		ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://localhost:" + myApp1.getMappedPort(8080) + "/profile", String.class);
		ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:" + myApp2.getMappedPort(8080)+ "/profile", String.class);
		System.out.println(forEntity1.getBody());
		System.out.println(forEntity2.getBody());
		Assertions.assertEquals("Current profile is production",forEntity1.getBody());
		Assertions.assertEquals("Current profile is dev",forEntity2.getBody());
	}

}
