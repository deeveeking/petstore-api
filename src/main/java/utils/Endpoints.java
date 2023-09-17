package utils;

public class Endpoints {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String ADD_NEW_PET = "/pet";
    public static final String PET_ACTIONS = "/pet/";
    public static final String FIND_PET_BY_STATUS = "/pet/findByStatus";
    public static final String CREATE_ORDER = "/store/order";
    public static final String ORDER_ACTIONS = "/store/order/";
    public static final String USER_ACTIONS = "/user/";
    public static final String CREATE_USER = "/user";

    Endpoints() {
        throw new IllegalStateException("This is utility class.");
    }
}
