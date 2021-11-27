package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.DictDataDTO;
import com.sky.exception.BusinessException;
import com.sky.service.SysDictDataService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 字典数据控制器
 * @author sky
 * @create 2021-11-27 16:14
 */
@RestController
@RequestMapping("/dict/data")
@PreAuthorize("hasAuthority('system_dict')")
public class SysDictDataController {
    @Autowired
    private SysDictDataService dictDataService;

    // 分页查询
    @GetMapping("/listForPage")
    public R listForPage(DictDataDTO dictDataDto) {
        DataGridView dataGridView = dictDataService.listPage(dictDataDto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }

    // 新增字典数据
    @PostMapping("/addDictData")
    public R addDictData(@Validated DictDataDTO dictDataDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        dictDataDto.setSimpleUser(user);
        return R.toAjax(this.dictDataService.insert(dictDataDto));
    }

    // 修改字典数据
    @PutMapping("/updateDictData")
    public R updateDictData(@Validated DictDataDTO dictDataDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        dictDataDto.setSimpleUser(user);
        return R.toAjax(this.dictDataService.update(dictDataDto));
    }

    // 批量删除字典数据
    @DeleteMapping("/deleteDictDataByIds/{dictCodeIds}")
    public R deleteDictDataByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] dictCodeIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.dictDataService.deleteDictDataByIds(dictCodeIds));
    }

    // 根据字典数据ID查询字典数据
    @GetMapping("/getOne/{dictCode}")
    public R getOne(@PathVariable @Validated @NotNull(message = "要查找的ID不能为空") Long dictCode) {
        return R.success(this.dictDataService.selectDictDataById(dictCode));
    }

    // 通过字典类型查询字典数据【公共的】
    @GetMapping("/getDataByType/{dictType}")
    public R getDataByType(@PathVariable @Validated @NotBlank(message = "字典类型不能为空") String dictType) {
        return R.success(this.dictDataService.selectDictDataByDictType(dictType));
    }
}
