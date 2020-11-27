package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.book.BookDTO;
import io.github.talelin.latticy.mapper.BookMapper;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Integer create(BookDTO bookDTO) {

        BookDO bookDO = new BookDO();

        BeanUtils.copyProperties(bookDTO, bookDO);

        return bookMapper.insert(bookDO);
    }

    @Override
    public Integer delete(Integer id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public Integer update(Integer id, BookDTO bookDTO) {
        BookDO bookDO = new BookDO();
        bookDO.setId(id);
        BeanUtils.copyProperties(bookDTO, bookDO);
        return bookMapper.updateById(bookDO);
    }

    @Override
    public BookDO query(Integer id) {
        BookDO bookDO = bookMapper.selectById(id);
        if (bookDO == null) throw new NotFoundException();
        return bookDO;
    }

    @Override
    public IPage<BookDO> queryAll(Integer page, Integer count) {
        Page<BookDO> pager = new Page<>(page, count);
        return bookMapper.selectPage(pager, null);
    }
}