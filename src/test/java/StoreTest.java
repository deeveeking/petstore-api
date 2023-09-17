import base.BaseTest;
import io.restassured.response.Response;
import models.OrderModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.StoreSteps;
import utils.GenerateModelUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest extends BaseTest {
    private OrderModel orderModel;

    @BeforeTest(alwaysRun = true)
    public void createModel() {
        orderModel = GenerateModelUtil.generateAndGetOrderModel();
    }

    @Test
    public void createOrderTest() {
        Response createOrderResponse = StoreSteps.createOrder(orderModel, HttpStatus.SC_OK);

        OrderModel responseOrderModel = createOrderResponse.as(OrderModel.class);

        assertThat(responseOrderModel.getOrderId())
                .as("OrderID should be correct")
                .isEqualTo(orderModel.getOrderId());
        assertThat(responseOrderModel.getPetId())
                .as("PetID should be correct")
                .isEqualTo(orderModel.getPetId());
        assertThat(responseOrderModel.getQuantity())
                .as("Quantity should be correct")
                .isEqualTo(orderModel.getQuantity());
        assertThat(responseOrderModel.getOrderStatus())
                .as("Order status should be correct")
                .isEqualTo(orderModel.getOrderStatus());

        // TODO uncomment after fix CORE-000
        /*assertThat(responseOrderModel.getShipDate())
                .as("Ship date should be correct")
                .isEqualTo(orderModel.getShipDate());*/
    }

    @Test
    public void getOrderByOrderIdTest() {
        StoreSteps.createOrder(orderModel, HttpStatus.SC_OK);

        Response findOrderResponse = StoreSteps.getOrderByOrderId(orderModel.getOrderId(), HttpStatus.SC_OK);

        OrderModel responseOrderModel = findOrderResponse.as(OrderModel.class);

        assertThat(responseOrderModel.getOrderId())
                .as("OrderID should be correct")
                .isEqualTo(orderModel.getOrderId());
        assertThat(responseOrderModel.getPetId())
                .as("PetID should be correct")
                .isEqualTo(orderModel.getPetId());
        assertThat(responseOrderModel.getQuantity())
                .as("Quantity should be correct")
                .isEqualTo(orderModel.getQuantity());
        assertThat(responseOrderModel.getOrderStatus())
                .as("Order status should be correct")
                .isEqualTo(orderModel.getOrderStatus());
    }

    @Test
    public void getOrderByIncorrectOrderIdTest() {
        StoreSteps.getOrderByOrderId(orderModel.getOrderId(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void deleteOrderTest() {
        StoreSteps.createOrder(orderModel, HttpStatus.SC_OK);

        StoreSteps.deleteOrderByOrderId(orderModel.getOrderId(), HttpStatus.SC_OK);

        StoreSteps.getOrderByOrderId(orderModel.getOrderId(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void deleteOrderByIncorrectOrderIdTest() {
        StoreSteps.deleteOrderByOrderId(orderModel.getOrderId(), HttpStatus.SC_NOT_FOUND);
    }

    // TODO I can do more tests, but this is just a test project
}
