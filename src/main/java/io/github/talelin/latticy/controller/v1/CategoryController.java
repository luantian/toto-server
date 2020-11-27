package io.github.talelin.latticy.controller.v1;

import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.latticy.dto.category.CategoryDTO;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.service.CategoryService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/category")
@Validated
@PermissionModule(value = "分类管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    @GroupRequired
    @PermissionMeta(value = "创建分类")
    public CreatedVO create(
            @RequestBody @Valid CategoryDTO validator
            ) {
        categoryService.create(validator);
        return new CreatedVO();
    }

    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除分类")
    public DeletedVO delete(
            @PathVariable @Positive(message = "{id.positive}") Integer id
    ) {
        categoryService.delete(id);
        return new DeletedVO();
    }

    @PutMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "更改分类")
    public UpdatedVO update(
            @PathVariable @Positive(message = "{id.positive}") Integer id,
            @RequestBody @Valid CategoryDTO validator
    ) {
        categoryService.update(id, validator);
        return new UpdatedVO();
    }

    @GetMapping("/{id}")
    public CategoryDO query(
            @PathVariable @Positive(message = "{id.positive}") Integer id
    ) {
        return categoryService.query(id);
    }

    @GetMapping("/all")
    public List<CategoryDO> queryAll() {
        return categoryService.queryAll();
    }

}
