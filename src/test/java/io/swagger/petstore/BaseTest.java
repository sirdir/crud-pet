package io.swagger.petstore;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/"; //todo move to config
        RestAssured.basePath = "v2/pet"; //todo move to config
        RestAssured.filters(new AllureRestAssured());
    }
}
