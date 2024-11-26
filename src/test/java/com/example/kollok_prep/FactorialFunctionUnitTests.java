package com.example.kollok_prep;

import com.example.kollok_prep.controllers.FactorialController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialFunctionUnitTests {

	private FactorialController factorialController;

	@BeforeEach
	public void setUp() {
		factorialController = new FactorialController();
	}

	@Test
	public void testGetFactorials_ValidInput() {
		ResponseEntity<List<Long>> response = factorialController.getFactorials(5);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(5, response.getBody().size());
		assertEquals(List.of(1L, 1L, 2L, 6L, 24L), response.getBody());
	}

	@Test
	public void testGetFactorials_InvalidInput_Negative() {
		ResponseEntity<List<Long>> response = factorialController.getFactorials(-1);

		assertEquals(400, response.getStatusCodeValue());
		assertEquals(null, response.getBody());
	}

	@Test
	public void testGetFactorials_InvalidInput_Zero() {
		ResponseEntity<List<Long>> response = factorialController.getFactorials(0);

		assertEquals(400, response.getStatusCodeValue());
		assertEquals(null, response.getBody());
	}
}
