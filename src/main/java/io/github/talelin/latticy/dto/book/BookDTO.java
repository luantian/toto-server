package io.github.talelin.latticy.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BookDTO {

    @NotEmpty(message = "{book.title.not-empty}")
    @Length(max = 50, message = "{book.title.length}")
    private String title;

    @NotEmpty(message = "{book.author.not-empty}")
    @Length(max = 50, message = "{book.author.length}")
    private String author;

    @NotEmpty(message = "{book.summary.not-empty}")
    @Length(max = 1000, message = "{book.summary.length}")
    private String summary;

    @Length(max = 255, message = "{book.img.length}")
    @NotEmpty(message = "{book.image.not-empty}")
    private String image;

//    @Length(max = 50, message = "{book.press.length}")
//    @NotEmpty(message = "{book.press.not-empty}")
    private String press;

//    @Length(max = 20, message = "{book.isbn.length}")
//    @NotEmpty(message = "{book.isbn.not-empty}")
    private String isbn;

    @Positive(message = "{category.id.positive}")
    @NotNull(message = "{category.id.not-null}")
    private Integer categoryId;

    @NotNull(message = "{book.price.not-null}")
    private BigDecimal price;
}
