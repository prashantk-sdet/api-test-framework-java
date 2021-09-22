package com.qa.petstore.services;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.qa.petstore.models.Pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetService {
	private static final Logger LOGGER = LogManager.getLogger(PetService.class.getName());

	public static Response getPetByPetId(String petId) {
		return given()
				.auth()
				.none()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.get("/pet/" + petId);
	}

	public static Response getPetFindByStatus(String status) {
		return given()
				.auth()
				.none()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.param("status", status)
				.get("/pet/findByStatus");
	}
	
	
	public static Response postPet(String petJson) {
		Response response = given().header("Content-type", "application/json").and().body(petJson).when()
				.post("/pet").then().extract().response();

		return response;

	}
	
	public static Pet addNewPetToStore() {
		Pet pet = new Pet("testPet","testCategory","", "testTag");
		Gson gson = new Gson();
		String petJson = gson.toJson(pet);
		LOGGER.info("customerJson : " + petJson);
		Response resp = postPet(petJson);
		resp.then().statusCode(200);
		return gson.fromJson(resp.asString(), Pet.class);

	}
	
	public static void comparePetObjects(Pet newPet, Pet getResponsePet) {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(newPet.getName(), getResponsePet.getName(), "Pet name from get request is not equal to newly added pet");
		sa.assertEquals(newPet.getStatus(), getResponsePet.getStatus(), "Pet status from get request is not equal to newly added pet");
		sa.assertAll();
	}

}
