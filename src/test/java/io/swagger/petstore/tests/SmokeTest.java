package io.swagger.petstore.tests;

import io.restassured.response.Response;
import io.swagger.petstore.pojo.pet.Pet;
import io.swagger.petstore.pojo.pet.PetFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.swagger.petstore.steps.SendRequests.*;

public class SmokeTest extends BaseTest {


    @Test(description  = "Create -> Update -> Read -> Delete")
    public void crudFullJourney() {
        //crete
        Pet cat = PetFactory.defaultPet();
        Response createResponse = createPet(cat);
        createResponse.then().statusCode(200);
        Pet catAfterCreate =createResponse.as(Pet.class);

        Assert.assertEquals(catAfterCreate, cat, "after create");

        //full update
        Pet newCat = PetFactory.petWithCategoryAndTag("customCat", "customTag");
        Response updateResponse = updatePet(newCat);
        updateResponse.then().statusCode(200);
        Pet catAfterUpdate = updateResponse.as(Pet.class);

        Assert.assertEquals(catAfterUpdate, newCat, "after update");

        //read
        Response readResponse = getPetById(newCat.getId());
        readResponse.then().statusCode(200);
        Pet catAfterRead = readResponse.as(Pet.class);

        Assert.assertEquals(catAfterRead, newCat, "after read");

        //delete
        Response deleteResponse = deletePet(cat.getId());
        deleteResponse.then().statusCode(200);
    }

    @Test(description  = "get 404 error when delete not existed pat")
    public void deleteNotExistedPet() {
        Pet cat = PetFactory.defaultPet();
        Response createResponse = createPet(cat);
        createResponse.then().statusCode(200);

        Response deleteResponse1 = deletePet(cat.getId());
        deleteResponse1.then().statusCode(200);

        Response deleteResponse2 = deletePet(cat.getId());
        deleteResponse2.then().statusCode(404);
    }

    @Test(description  = "get 404 error when read not existed pat")
    public void getNotExistedPet() {
        Pet cat = PetFactory.defaultPet();
        Response createResponse = createPet(cat);
        createResponse.then().statusCode(200);

        Response deleteResponse1 = deletePet(cat.getId());
        deleteResponse1.then().statusCode(200);

        Response deleteResponse2 = getPetById(cat.getId());
        deleteResponse2.then().statusCode(404);
    }


}
