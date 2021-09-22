package com.qa.petstore;
import static io.restassured.RestAssured.baseURI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.qa.petstore.models.Pet;
import com.qa.petstore.services.PetService;

import io.restassured.response.Response;

public class PetTests {
	private static final Logger LOGGER = LogManager.getLogger(PetTests.class.getName());


  @BeforeClass
  public void beforeClass() {
	  baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  public void validateFindPetByIdService() {

	  Gson gson = new Gson();
	  Pet newPet = PetService.addNewPetToStore();
	  Response resp = PetService.getPetByPetId(newPet.getId() + "");
	  System.out.println(resp.asPrettyString());
	  Pet getResponsePet = gson.fromJson(resp.asPrettyString(), Pet.class);
	  PetService.comparePetObjects(newPet,getResponsePet);
  }

}
