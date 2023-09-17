package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.OrderModel;
import steps.base.BaseSteps;
import utils.Endpoints;

public class StoreSteps extends BaseSteps {

    StoreSteps() {
        throw new IllegalStateException("This is steps class.");
    }

    public static Response createOrder(OrderModel orderModel, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(Endpoints.CREATE_ORDER)
                          .body(orderModel)
                          .post()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response getOrderByOrderId(int orderId, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.ORDER_ACTIONS, orderId))
                          .get()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }

    public static Response deleteOrderByOrderId(int orderId, int expectedStatus) {
        return RestAssured.given(requestSpecification)
                          .basePath(String.format("%s%s", Endpoints.ORDER_ACTIONS, orderId))
                          .delete()
                          .then()
                          .statusCode(expectedStatus)
                          .extract()
                          .response();
    }
}
