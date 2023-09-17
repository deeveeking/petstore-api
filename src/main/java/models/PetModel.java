package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class PetModel {
    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String petName;

    @JsonProperty("id")
    private int petId;

    @JsonProperty("category")
    private CategoryModel petCategory;

    @JsonProperty("tags")
    private List<TagModel> tags;

    @JsonProperty("status")
    private String petStatus;
}
