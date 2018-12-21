package io.swagger.petstore.tests;

import io.restassured.response.Response;
import io.swagger.petstore.pojo.pet.Pet;
import io.swagger.petstore.pojo.pet.PetFactory;
import org.testng.annotations.Test;

import static io.swagger.petstore.steps.SendRequests.*;

public class SmokeTest extends BaseTest {

    @Test(testName = "Create -> Read -> full Update -> Read -> Delete -> Read")
    public void crufrdr() {
        //crete
        Pet cat = PetFactory.defaultPet();
        Response response1 = createEntity(cat);

        response1.then().statusCode(200);
        //read
        Response response2 = getEntityById(cat.getId());
        response2.then().statusCode(200);

        //full update
        Pet newCat = PetFactory.petWithCategoryAndTag("customCat", "customTag");
        Response response3 = updateFullEntity(newCat);
        response3.then().statusCode(200);

        //read
        Response response4 = getEntityById(cat.getId());
        response4.then().statusCode(200);


        //delete
        Response response5 = deleteEntity(cat.getId());
        response5.then().statusCode(200);


        //read
        Response response6 = getEntityById(cat.getId());
        response6.then().statusCode(404);

    }

    @Test(testName = "Create -> Read -> fields Update -> Read -> Delete -> Read")
    public void cruprdr() {
//        Pet cat = PetFactory.defaultPet();
//        Response response = getEntityById(cat.getId());
//
//        response.then().statusCode(200);
    }

}
