package com.sky.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.LogOperInfoMapper;
import com.sky.domain.LogOperInfo;
import com.sky.service.LogOperInfoService;

/**
 * @author sky
 * @create 2021-12-14 10:50
 */
@Service
public class LogOperInfoServiceImpl extends ServiceImpl<LogOperInfoMapper, LogOperInfo> implements LogOperInfoService {

}
