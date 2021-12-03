package com.sky.service;

import com.sky.domain.TimeTomato;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.TimeTomatoDTO;

/**
 * @author sky
 * @create 2021-12-03 17:35
 */
public interface TimeTomatoService extends IService<TimeTomato> {


    int add(TimeTomatoDTO dto);
}
