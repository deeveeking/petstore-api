package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.UserModel;
import steps.base.BaseSteps;
import utils.Endpoints;

public class UserSteps extends BaseSteps {

    UserSteps() {
        throw new IllegalStateException("This is steps class.");
    }

    public static Response createUser(UserModel userModel, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(Endpoints.CREATE_USER)
                          .body(userModel)
                          .post()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response findUserByUserName(String userName, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.USER_ACTIONS, userName))
                          .get()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response updateUserByUserName(String userName, UserModel userModel, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.USER_ACTIONS, userName))
                          .body(userModel)
                          .put().then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response deleteUserByUserName(String userName, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.USER_ACTIONS, userName))
                          .delete()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }
}
