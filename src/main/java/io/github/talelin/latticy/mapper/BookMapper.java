package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BookDO;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<BookDO> {

}
