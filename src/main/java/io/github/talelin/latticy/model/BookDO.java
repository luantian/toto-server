package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("book")
@EqualsAndHashCode(callSuper = true)
public class BookDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 3531805912578317266L;

    private String title;
    private String image;
    private String author;
    private String press;
    private String summary;
    private String isbn;
    private Integer categoryId;
    private BigDecimal price;
}
