package com.qa.petstore;
import static io.restassured.RestAssured.baseURI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.qa.petstore.models.Pet;
import com.qa.petstore.services.PetService;
import com.qa.petstore.services.StoreService;
import com.qa.petstore.services.UserService;

import io.restassured.response.Response;

public class UserTests {
	private static final Logger LOGGER = LogManager.getLogger(UserTests.class.getName());


  @BeforeClass
  public void beforeClass() {
	  baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  public void validateGetUserByUserNameService() {

	  Response getUserByUserNameResp = UserService.getUserByUserName("test");
	  UserService.validateGetUserByUserNameResponse(getUserByUserNameResp);
  }

}
