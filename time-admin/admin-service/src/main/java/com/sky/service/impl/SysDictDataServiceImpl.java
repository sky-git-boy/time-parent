package com.sky.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.constants.Constants;
import com.sky.dto.DictDataDTO;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysDictDataMapper;
import com.sky.domain.SysDictData;
import com.sky.service.SysDictDataService;

/**
 * @author sky
 * @create 2021-11-27 16:03
 */
@Service
public class SysDictDataServiceImpl implements SysDictDataService {
    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public DataGridView listPage(DictDataDTO dictDataDto) {
        QueryWrapper<SysDictData> qw = new QueryWrapper<>();
        Page<SysDictData> page = new Page<>(dictDataDto.getPageNum(), dictDataDto.getPageSize());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getDictType()), SysDictData.COL_DICT_TYPE, dictDataDto.getDictType());
        qw.like(StringUtils.isNotBlank(dictDataDto.getDictLabel()), SysDictData.COL_DICT_LABEL, dictDataDto.getDictLabel());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getStatus()), SysDictData.COL_STATUS, dictDataDto.getStatus());
        this.dictDataMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int insert(DictDataDTO dictDataDto) {
        SysDictData dictData = new SysDictData();
        BeanUtils.copyProperties(dictDataDto, dictData);
        // 设置创建者，创建时间
        dictData.setCreateBy(dictDataDto.getSimpleUser().getUserId());
        dictData.setCreateTime(DateUtil.date());
        return this.dictDataMapper.insert(dictData);
    }

    @Override
    public SysDictData selectDictDataById(Long dictCode) {
        return this.dictDataMapper.selectById(dictCode);
    }

    @Override
    public int update(DictDataDTO dictDataDto) {
        SysDictData dictData = new SysDictData();
        BeanUtils.copyProperties(dictDataDto, dictData);
        // 设置修改人，修改时间
        dictData.setUpdateBy(dictDataDto.getSimpleUser().getUserId());
        dictData.setUpdateTime(DateUtil.date());
        return this.dictDataMapper.updateById(dictData);
    }

    @Override
    public int deleteDictDataByIds(Long[] dictCodeIds) {
        List<Long> ids = Arrays.asList(dictCodeIds);
        if (ids.size() > 0) {
            return this.dictDataMapper.deleteBatchIds(ids);
        } else {
            return -1;
        }
    }

    @Override
    public List<SysDictData> selectDictDataByDictType(String dictType) {
        // 从 redis 中查询
        String key = Constants.DICT_REDIS_PROFIX + dictType;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String json = ops.get(key);
        return JSON.parseArray(json, SysDictData.class);
    }
}
