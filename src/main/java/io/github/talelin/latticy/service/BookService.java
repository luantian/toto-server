package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.dto.book.BookDTO;
import io.github.talelin.latticy.model.BookDO;

import java.util.List;

public interface BookService extends IService<BookDO> {
    Integer create(BookDTO bookDTO);
    Integer delete(Integer id);

    Integer update(Integer id, BookDTO bookDTO);

    IPage<BookDO> queryAll(Integer page, Integer count);
}
