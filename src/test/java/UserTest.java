import base.BaseTest;
import io.restassured.response.Response;
import models.UserModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.UserSteps;
import utils.GenerateModelUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest extends BaseTest {
    private UserModel userModel;

    @BeforeTest(alwaysRun = true)
    public void createModel() {
        userModel = GenerateModelUtil.generateAndGetUserModel();
    }

    @Test
    public void createAndGetUserTest() {
        UserSteps.createUser(userModel, HttpStatus.SC_OK);

        Response findUserResponse = UserSteps.findUserByUserName(userModel.getUserName(), HttpStatus.SC_OK);

        UserModel findUserModel = findUserResponse.as(UserModel.class);

        assertThat(findUserModel.getUserId())
                .as("UserID should be correct")
                .isEqualTo(userModel.getUserId());
        assertThat(findUserModel.getUserName())
                .as("User name should be correct")
                .isEqualTo(userModel.getUserName());
        assertThat(findUserModel.getUserStatus())
                .as("User status should be correct")
                .isEqualTo(userModel.getUserStatus());
        assertThat(findUserModel.getEmail())
                .as("User email should be correct")
                .isEqualTo(userModel.getEmail());
        assertThat(findUserModel.getLastName())
                .as("User last name should be correct")
                .isEqualTo(userModel.getLastName());
        assertThat(findUserModel.getFirstName())
                .as("User first name should be correct")
                .isEqualTo(userModel.getFirstName());
        assertThat(findUserModel.getPassword())
                .as("User password should be correct")
                .isEqualTo(userModel.getPassword());
        assertThat(findUserModel.getPhoneNumber())
                .as("User phone number should be correct")
                .isEqualTo(userModel.getPhoneNumber());
    }

    @Test
    public void getUserByIncorrectUserNameTest() {
        UserSteps.findUserByUserName(userModel.getUserName(), HttpStatus.SC_NOT_FOUND);
    }

    // TODO enable test after fix CORE-098
    @Test(enabled = false)
    public void updateUserTest() {
        UserSteps.createUser(userModel, HttpStatus.SC_OK);

        UserModel newExpectedUserModel = GenerateModelUtil.generateAndGetUserModel();

        UserSteps.updateUserByUserName(userModel.getUserName(), newExpectedUserModel, HttpStatus.SC_OK);

        Response findUserResponse = UserSteps.findUserByUserName(userModel.getUserName(), HttpStatus.SC_OK);

        UserModel findUserModel = findUserResponse.as(UserModel.class);

        assertThat(findUserModel.getUserId())
                .as("UserID should be correct")
                .isEqualTo(newExpectedUserModel.getUserId());
        assertThat(findUserModel.getUserName())
                .as("User name should be correct")
                .isEqualTo(newExpectedUserModel.getUserName());
        assertThat(findUserModel.getUserStatus())
                .as("User status should be correct")
                .isEqualTo(newExpectedUserModel.getUserStatus());
        assertThat(findUserModel.getEmail())
                .as("User email should be correct")
                .isEqualTo(newExpectedUserModel.getEmail());
        assertThat(findUserModel.getLastName())
                .as("User last name should be correct")
                .isEqualTo(newExpectedUserModel.getLastName());
        assertThat(findUserModel.getFirstName())
                .as("User first name should be correct")
                .isEqualTo(newExpectedUserModel.getFirstName());
        assertThat(findUserModel.getPassword())
                .as("User password should be correct")
                .isEqualTo(newExpectedUserModel.getPassword());
        assertThat(findUserModel.getPhoneNumber())
                .as("User phone number should be correct")
                .isEqualTo(newExpectedUserModel.getPhoneNumber());
    }

    @Test
    public void deleteUserTest() {
        UserSteps.createUser(userModel, HttpStatus.SC_OK);

        UserSteps.deleteUserByUserName(userModel.getUserName(), HttpStatus.SC_OK);

        UserSteps.findUserByUserName(userModel.getUserName(), HttpStatus.SC_NOT_FOUND);
    }

    // TODO I can do more tests, but this is just a test project
}
