package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.model.CategoryDO;

import java.util.List;

public interface CategoryService extends IService<CategoryDO> {
    Integer create(CategoryDTO categoryDTO);

    Integer delete(Integer id);

    Integer update(Integer id, CategoryDTO categoryDTO);

    CategoryDO query(Integer id);

    List<CategoryDO> queryAll();


}
