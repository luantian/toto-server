package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("category")
@EqualsAndHashCode(callSuper = true)
public class CategoryDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = -1854726674088671800L;

    private String name;
    private Integer pid;
    private Integer level;

}
