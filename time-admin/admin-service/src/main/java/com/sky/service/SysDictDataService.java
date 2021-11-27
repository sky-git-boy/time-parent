package com.sky.service;

import com.sky.domain.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.DictDataDTO;
import com.sky.vo.DataGridView;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-27 16:03
 */
public interface SysDictDataService {

    // 分页查询字典数据
    DataGridView listPage(DictDataDTO dictDataDto);

    // 添加字典数据
    int insert(DictDataDTO dictDataDto);

    // 根据字典数据ID查询字典数据
    SysDictData selectDictDataById(Long dictCode);

    // 更新字典数据
    int update(DictDataDTO dictDataDto);

    // 根据字典数据IDs删除字典信息
    int deleteDictDataByIds(Long[] dictCodeIds);

    // 根据字典类型查询字典数据【公共的】
    List<SysDictData> selectDictDataByDictType(String dictType);
}
