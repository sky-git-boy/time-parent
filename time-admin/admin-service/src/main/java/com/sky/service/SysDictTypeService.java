package com.sky.service;


import com.sky.domain.SysDictType;
import com.sky.dto.DictTypeDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-11-27 15:18
 */
public interface SysDictTypeService {

    /**
     * 分页查询字典类型
     * （含条件查询）
     */
    DataGridView listPage(DictTypeDTO dictTypeDto);

    /**
     * 查询所有字典类型（可用）
     */
    DataGridView list();

    /**
     * 检查字典类型是否存在
     */
    Boolean checkDictTypeUnique(Long dictId,String dictType);

    /**
     * 添加字典类型
     */
    int insert(DictTypeDTO dictTypeDto);

    /**
     * 更新字典类型
     */
    int update(DictTypeDTO dictTypeDto);

    /**
     * 根据 ID 批量删除字典类型
     */
    int deleteDictTypeByIds(Long[] dictIds);

    /**
     * 根据 ID 查询一个字典类型
     */
    SysDictType selectDictTypeById(Long dictId);
    
}
