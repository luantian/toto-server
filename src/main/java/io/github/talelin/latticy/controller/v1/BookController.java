package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.book.BookDTO;
import io.github.talelin.latticy.mapper.BookMapper;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.service.BookService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
@PermissionModule(value = "图书管理")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    @PermissionMeta(value = "添加图书")
    @GroupRequired
    public CreatedVO create(
            @RequestBody @Valid BookDTO bookDTO
            ) {
        bookService.create(bookDTO);
        return new CreatedVO();
    }

    @DeleteMapping("/{id}")
    @PermissionMeta(value = "删除图书")
    @GroupRequired
    public DeletedVO delete(
            @PathVariable @Positive(message = "{id.positive}") Integer id
    ) {

        bookService.delete(id);

        return new DeletedVO();
    }

    @PutMapping("/{id}")
    @PermissionMeta(value = "更改图书")
    @GroupRequired
    public UpdatedVO update(
            @PathVariable @Positive(message = "{id.positive}") Integer id,
            @RequestBody @Valid BookDTO bookDTO
    ) {
        bookService.update(id, bookDTO);
        return new UpdatedVO();
    }

    @GetMapping("/{id}")
    public BookDO query(
            @PathVariable @Positive(message = "{id.positive}") Integer id
    ) {
        return bookService.query(id);
    }

    @GetMapping("/all")
    public PageResponseVO<BookDO> queryAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer count
    ) {

        IPage<BookDO> paging = bookService.queryAll(page, count);

        return PageUtil.build(paging);

    }

}
