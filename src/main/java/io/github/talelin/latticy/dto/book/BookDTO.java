package io.github.talelin.latticy.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
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
    private String image;

    @Length(max = 50, message = "{book.press.length}")
    @NotEmpty(message = "{book.press.not-empty}")
    private String press;

    @Length(max = 20, message = "{book.isbn.length}")
    @NotEmpty(message = "{book.isbn.not-empty}")
    private String isbn;

    private BigDecimal price;
}
