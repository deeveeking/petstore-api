package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UserModel {
    @JsonProperty("id")
    private int userId;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phoneNumber;

    @JsonProperty("userStatus")
    private int userStatus;
}
