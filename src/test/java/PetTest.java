import base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import models.PetModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.PetSteps;
import utils.GenerateModelUtil;

public class PetTest extends BaseTest {
    private PetModel petModel;

    @BeforeTest(alwaysRun = true)
    public void createModel() {
        petModel = GenerateModelUtil.generateAndGetPetModel();
    }

    @Test
    public void addPetTest() {
        Response createPetResponse = PetSteps.addNewPet(petModel, HttpStatus.SC_OK);

        PetModel responseModel = createPetResponse.as(PetModel.class);

        assertThat(responseModel.getPetId())
                .as("PetID should be correct")
                .isEqualTo(petModel.getPetId());
        assertThat(responseModel.getPetName())
                .as("Pet name should be correct")
                .isEqualTo(petModel.getPetName());
        assertThat(responseModel.getPetCategory().getCategoryId())
                .as("CategoryID should be correct")
                .isEqualTo(petModel.getPetCategory().getCategoryId());
        assertThat(responseModel.getPetCategory().getCategoryName())
                .as("Category name should be correct")
                .isEqualTo(petModel.getPetCategory().getCategoryName());
        assertThat(responseModel.getTags())
                .as("Tags should be correct")
                .isEqualTo(petModel.getTags());
        assertThat(responseModel.getPhotoUrls())
                .as("PhotoURLs should be correct")
                .isEqualTo(petModel.getPhotoUrls());
    }

    @Test
    public void addAndGetPetTest() {
        PetSteps.addNewPet(petModel, HttpStatus.SC_OK);

        Response getPetResponse = PetSteps.getPet(petModel.getPetId(), HttpStatus.SC_OK);

        PetModel responseModel = getPetResponse.as(PetModel.class);

        assertThat(responseModel.getPetId())
                .as("PetID should be correct")
                .isEqualTo(petModel.getPetId());
        assertThat(responseModel.getPetName())
                .as("Pet name should be correct")
                .isEqualTo(petModel.getPetName());
        assertThat(responseModel.getPetCategory().getCategoryId())
                .as("CategoryID should be correct")
                .isEqualTo(petModel.getPetCategory().getCategoryId());
        assertThat(responseModel.getPetCategory().getCategoryName())
                .as("Category name should be correct")
                .isEqualTo(petModel.getPetCategory().getCategoryName());
        assertThat(responseModel.getTags())
                .as("Tags should be correct")
                .isEqualTo(petModel.getTags());
        assertThat(responseModel.getPhotoUrls())
                .as("PhotoURLs should be correct")
                .isEqualTo(petModel.getPhotoUrls());
    }

    @Test
    public void getPetByIncorrectIdTest() {
       PetSteps.getPet(petModel.getPetId(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void findPetByStatusTest() {
        PetSteps.addNewPet(petModel, HttpStatus.SC_OK);

        Response findPetResponse = PetSteps.findPetByStatus(petModel.getPetStatus(), HttpStatus.SC_OK);

        assertThat(findPetResponse.asString())
                .as("Response should contain pet with status")
                .isNotEmpty();

    }

    // TODO enable test after fix CORE-098
    @Test(enabled = false)
    public void findPetByIncorrectStatusTest() {
        PetSteps.findPetByStatus("111", HttpStatus.SC_NOT_FOUND);
    }

    // TODO I can do more tests, but this is just a test project
}
