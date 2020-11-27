package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.CategoryDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper extends BaseMapper<CategoryDO> {
    int selectCountByName(String name);
}
