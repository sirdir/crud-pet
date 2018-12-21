package io.swagger.petstore.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.petstore.pojo.Category;
import io.swagger.petstore.pojo.Pet;
import io.swagger.petstore.pojo.Tag;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class SmokeTest extends BaseTest {

    @Test
    public void postTest(){
        //todo json here just for debug
        Category cat = new Category();
        cat.setId(1);
        cat.setName("kitty cat");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("fat cat");

        Pet pet = new Pet();
        pet.setCategory(cat);
        pet.setTags(Collections.singletonList(tag));
        pet.setId(123321);
        pet.setName("leroy jenkins");
        pet.setStatus("available");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .post();

        response.then().statusCode(200);
        Pet petResponse = response.as(Pet.class);
        System.out.println("petResponse = " + petResponse);
    }

    @Test
    public void getTest(){

    }

    @Test
    public void updateFullTest(){

    }

    @Test
    public void updatePartlyTest(){

    }

    @Test
    public void deleteTest(){

    }
}
