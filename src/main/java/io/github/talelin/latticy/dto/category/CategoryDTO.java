package io.github.talelin.latticy.dto.category;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CategoryDTO {

    @NotBlank(message = "{category.not-empty}")
    private String name;
    private Integer pid;
    private Integer level;
}
