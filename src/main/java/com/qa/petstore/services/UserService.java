package com.qa.petstore.services;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.qa.petstore.models.Pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserService.class.getName());

	public static Response getUserByUserName(String username) {
		return given()
				.auth()
				.none()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.get("/user/" + username);
	}
	
	public static void validateGetUserByUserNameResponse(Response getUserByUserNameResponse) {
		Assert.assertEquals(getUserByUserNameResponse.statusCode(),200);
	}

}
