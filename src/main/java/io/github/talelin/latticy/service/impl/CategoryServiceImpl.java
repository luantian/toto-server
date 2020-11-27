package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.ForbiddenException;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Integer create(CategoryDTO categoryDTO) {
        boolean exist = categoryMapper.selectCountByName(categoryDTO.getName()) > 0;
        if (exist) throw new ForbiddenException(3000);
        CategoryDO categoryDO = new CategoryDO();
        BeanUtils.copyProperties(categoryDTO, categoryDO);
        return categoryMapper.insert(categoryDO);
    }

    @Override
    public Integer delete(Integer id) {
        CategoryDO categoryDO = categoryMapper.selectById(id);
        if (categoryDO == null) throw new NotFoundException();
        return categoryMapper.deleteById(id);
    }

    @Override
    public Integer update(Integer id, CategoryDTO categoryDTO) {
        CategoryDO categoryDO = categoryMapper.selectById(id);
        if (categoryDO == null) throw new NotFoundException();
        BeanUtils.copyProperties(categoryDTO, categoryDO);
        categoryDO.setId(id);
        return categoryMapper.updateById(categoryDO);
    }

    @Override
    public CategoryDO query(Integer id) {
        CategoryDO categoryDO = categoryMapper.selectById(id);
        if (categoryDO == null) throw new NotFoundException();
        return categoryDO;
    }

    @Override
    public List<CategoryDO> queryAll() {
        return categoryMapper.selectList(null);
    }



}
