package enums;

import lombok.Getter;

@Getter
public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String value;

    PetStatus(final String value) {
        this.value = value;
    }
}
