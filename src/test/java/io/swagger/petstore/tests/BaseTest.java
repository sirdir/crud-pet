package io.swagger.petstore.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import static io.swagger.petstore.utils.Config.*;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = PET_PATH;
        RestAssured.filters(new AllureRestAssured());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
