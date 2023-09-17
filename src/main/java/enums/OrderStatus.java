package enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private String value;

    OrderStatus(final String value) {
        this.value = value;
    }
}
