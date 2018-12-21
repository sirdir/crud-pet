package io.swagger.petstore.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.petstore.pojo.pet.Pet;

import static io.restassured.RestAssured.given;

public class SendRequests {

    @Step
    public static Response createPet(Pet pet) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
            .when()
                .post();
    }

    @Step
    public static Response getPetById(long petId) {

        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
            .when()
                .get("/{petId}");
    }

    @Step
    public static Response updatePet(Pet pet) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
            .when()
                .put();
    }

    @Step
    public static Response deletePet(long petId) {

        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
            .when()
                .delete("/{petId}");
    }

}
