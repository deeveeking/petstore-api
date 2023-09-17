package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CategoryModel {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("id")
    private int categoryId;
}
