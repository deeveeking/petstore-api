package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class OrderModel {
    @JsonProperty("id")
    private int orderId;

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("status")
    private String orderStatus;

    @JsonProperty("complete")
    private boolean isComplete;
}
