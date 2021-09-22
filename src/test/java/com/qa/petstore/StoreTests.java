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

import io.restassured.response.Response;

public class StoreTests {
	private static final Logger LOGGER = LogManager.getLogger(StoreTests.class.getName());


  @BeforeClass
  public void beforeClass() {
	  baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  public void validateGetStoreInventoryService() {

	  Response getStoreInventoryResp = StoreService.getStoreInventory();
	  StoreService.validateGetStoreInventoryResponse(getStoreInventoryResp);
  }

}
