package steps.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Endpoints;

public class BaseSteps {
    private static final String apiKeyValue = "deveeking";
    protected static RequestSpecification requestSpecification;

    public static void init() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", apiKeyValue)
                .setBaseUri(Endpoints.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
