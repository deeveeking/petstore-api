package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.PetModel;
import steps.base.BaseSteps;
import utils.Endpoints;

public class PetSteps extends BaseSteps {

    PetSteps() {
        throw new IllegalStateException("This is steps class.");
    }

    public static Response addNewPet(PetModel petModel, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(Endpoints.ADD_NEW_PET)
                          .body(petModel)
                          .post()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response getPet(int petId, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.PET_ACTIONS, petId))
                          .get()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response findPetByStatus(String petStatus, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(Endpoints.FIND_PET_BY_STATUS)
                          .queryParam("status", petStatus)
                          .get()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }
}