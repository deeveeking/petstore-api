package utils;

import enums.OrderStatus;
import enums.PetStatus;
import models.CategoryModel;
import models.PetModel;
import models.OrderModel;
import models.UserModel;

import java.time.Clock;

public class GenerateModelUtil {

    GenerateModelUtil() {
        throw new IllegalStateException("This is utility class.");
    }

    public static PetModel generateAndGetPetModel() {
        return PetModel.builder()
                .petId(GenerateUtil.generateRandomId())
                .petName(GenerateUtil.generateRandomName())
                .petStatus(PetStatus.AVAILABLE.getValue())
                .petCategory(generateAndGetCategoryModel())
                .photoUrls(null) // i don't use it
                .tags(null) // i don't use it
                .build();
    }

    public static CategoryModel generateAndGetCategoryModel() {
        return CategoryModel.builder()
                .categoryId(GenerateUtil.generateRandomId())
                .categoryName(GenerateUtil.generateRandomCategory())
                .build();
    }

    public static OrderModel generateAndGetOrderModel() {
        return OrderModel.builder()
                .petId(generateAndGetPetModel().getPetId())
                .orderId(GenerateUtil.generateRandomId())
                .quantity(GenerateUtil.generateRandomId())
                .shipDate(String.valueOf(Clock.systemUTC().instant()))
                .orderStatus(OrderStatus.PLACED.getValue())
                .isComplete(true)
                .build();
    }

    public static UserModel generateAndGetUserModel() {
        return UserModel.builder()
                .userId(GenerateUtil.generateRandomId())
                .email(GenerateUtil.generateRandomEmail())
                .userName(GenerateUtil.generateRandomName())
                .firstName(GenerateUtil.generateRandomFirstName())
                .lastName(GenerateUtil.generateLastName())
                .password(GenerateUtil.generateRandomPassword())
                .phoneNumber(GenerateUtil.generateRandomPhoneNumber())
                .userStatus(1)
                .build();
    }

    // TODO I can overload methods to create any models
}
