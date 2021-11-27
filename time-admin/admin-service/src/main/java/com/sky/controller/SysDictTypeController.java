package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.DictTypeDTO;
import com.sky.exception.BusinessException;
import com.sky.service.SysDictTypeService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 字典类型控制器
 * @author sky
 * @create 2021-11-27 15:22
 */
@RestController
@RequestMapping("dict/type")
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService dictTypeService;

    // 分页查询字典类型
    @GetMapping("/listForPage")
    public R listForPage(DictTypeDTO dictTypeDto) {
        DataGridView dataGridView = dictTypeService.listPage(dictTypeDto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }

    // 新增字典类型
    @PostMapping("/addDictType")
    public R addDictType(@Validated DictTypeDTO dictTypeDto) {
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return R.fail("新增字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        dictTypeDto.setSimpleUser(user);
        return R.toAjax(dictTypeService.insert(dictTypeDto));
    }

    // 根据字典类型ID查询一个字典信息
    @GetMapping("/getOne/{dictId}")
    public R getOne(@PathVariable @Validated @NotNull(message = "要查找的ID不能为空") Long dictId) {
        return R.success(this.dictTypeService.selectDictTypeById(dictId));
    }

    // 更新字典类型数据
    @PutMapping("/updateDictType")
    public R updateDictType(@Validated DictTypeDTO dictTypeDto) {
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return R.fail("修改字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        dictTypeDto.setSimpleUser(user);
        return R.toAjax(this.dictTypeService.update(dictTypeDto));
    }

    // 删除字典类型
    @DeleteMapping("/deleteDictTypeByIds/{dictIds}")
    public R deleteDictTypeByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] dictIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.dictTypeService.deleteDictTypeByIds(dictIds));
    }

    // 查询所有字典类型数据
    @GetMapping("selectAllDictType")
    public R selectAllDictType() {
        return R.success(this.dictTypeService.list().getData());
    }
}


