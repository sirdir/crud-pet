package io.swagger.petstore.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.petstore.pojo.pet.Pet;

import static io.restassured.RestAssured.given;

public class SendRequests {

    @Step
    public static Response createEntity(Pet pet) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
            .when()
                .post();
    }

    @Step
    public static Response getEntityById(long petId) {

        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
            .when()
                .get("/{petId}");
    }

    @Step
    public static Response updateEntityFields(Pet pet) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petId", pet.getId())
                .body(pet)
            .when()
                .post("/{petId}");
    }

    @Step
    public static Response updateFullEntity(Pet pet) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
            .when()
                .put();
    }

    @Step
    public static Response deleteEntity(long petId) {

        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
            .when()
                .delete("/{petId}");
    }

}
