package com.sky.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.constants.Constants;
import com.sky.domain.SysDictData;
import com.sky.domain.SysDictType;
import com.sky.dto.DictTypeDTO;
import com.sky.mapper.SysDictDataMapper;
import com.sky.mapper.SysDictTypeMapper;
import com.sky.service.SysDictTypeService;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author sky
 * @create 2021-11-27 15:18
 */
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {

    @Autowired
    private SysDictTypeMapper dictTypeMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Override
    public DataGridView listPage(DictTypeDTO dictTypeDto) {
        QueryWrapper<SysDictType> qw = new QueryWrapper<>();
        Page<SysDictType> page = new Page<>(dictTypeDto.getPageNum(), dictTypeDto.getPageSize());
        // 设置查询条件
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictName()), SysDictType.COL_DICT_NAME, dictTypeDto.getDictName());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictType()), SysDictType.COL_DICT_TYPE, dictTypeDto.getDictType());
        qw.eq(StringUtils.isNotBlank(dictTypeDto.getStatus()), SysDictType.COL_STATUS, dictTypeDto.getStatus());
        qw.ge(null != dictTypeDto.getBeginTime(), SysDictType.COL_CREATE_TIME, dictTypeDto.getBeginTime());
        qw.le(null != dictTypeDto.getEndTime(), SysDictType.COL_CREATE_TIME, dictTypeDto.getEndTime());
        this.dictTypeMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public DataGridView list() {
        QueryWrapper<SysDictType> qw = new QueryWrapper<>();
        // 查询可用的字典类型
        qw.eq(SysDictType.COL_STATUS, Constants.STATUS_TRUE);
        return new DataGridView(null, this.dictTypeMapper.selectList(qw));
    }

    @Override
    public Boolean checkDictTypeUnique(Long dictId, String dictType) {
        dictId = (dictId == null) ? -1L : dictId;
        QueryWrapper<SysDictType> qw = new QueryWrapper<>();
        qw.eq(SysDictType.COL_DICT_TYPE, dictType);
        SysDictType sysDictType = this.dictTypeMapper.selectOne(qw);
        // 返回true说明不存在，返回false说明存在
        return null != sysDictType && dictId.longValue() != sysDictType.getDictId().longValue();
    }

    @Override
    public int insert(DictTypeDTO dictTypeDto) {
        SysDictType dictType = new SysDictType();
        BeanUtil.copyProperties(dictTypeDto, dictType);
        dictType.setCreateTime(DateUtil.date());
        dictType.setCreateBy(dictTypeDto.getSimpleUser().getUserId());
        return this.dictTypeMapper.insert(dictType);
    }

    @Override
    public int update(DictTypeDTO dictTypeDto) {
        SysDictType dictType = new SysDictType();
        BeanUtil.copyProperties(dictTypeDto, dictType);
        dictType.setUpdateBy(dictTypeDto.getSimpleUser().getUserId());
        dictType.setUpdateTime(DateUtil.date());
        return this.dictTypeMapper.updateById(dictType);
    }

    @Override
    public int deleteDictTypeByIds(Long[] dictIds) {
        List<Long> ids = Arrays.asList(dictIds);
        if (ids.size() > 0) {
            return this.dictTypeMapper.deleteBatchIds(ids);
        } else {
            return -1;
        }
    }

    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        return this.dictTypeMapper.selectById(dictId);
    }

    // 同步缓存
    private void dictCacheAsync() {
        // 查询所有可用的 dictType
        QueryWrapper<SysDictType> qw = new QueryWrapper<>();
        qw.ge(SysDictType.COL_STATUS, Constants.STATUS_TRUE);
        List<SysDictType> dictTypes = this.dictTypeMapper.selectList(qw);
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();

        // 遍历字典类型
        for (SysDictType dictType : dictTypes) {
            // 获取字典数据
            QueryWrapper<SysDictData> qw2 = new QueryWrapper<>();
            qw2.ge(SysDictData.COL_STATUS, Constants.STATUS_TRUE);
            qw2.eq(SysDictData.COL_DICT_TYPE, dictType.getDictType());
            List<SysDictData> dictData = this.dictDataMapper.selectList(qw2);
            // 添加数据到redis中
            ops.set(Constants.DICT_REDIS_PROFIX + dictType.getDictType(), JSON.toJSONString(dictData));
        }
    }
}
