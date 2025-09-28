package com.example.automation.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyStatusAPI {

	@Test
	public void verifyStatusAPI() {
		Response res = given()

				.when().get("https://automationexercise.com/api/productsList");
		int statuscode = res.getStatusCode();

		Assert.assertEquals(statuscode, 200);

	}

}
