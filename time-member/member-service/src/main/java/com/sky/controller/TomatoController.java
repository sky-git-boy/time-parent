package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.TimeTomatoDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeTomatoService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 番茄钟控制器
 * @author sky
 * @create 2021-12-03 17:36
 */
@RestController
@RequestMapping("/tomato")
public class TomatoController {

    @Autowired
    private TimeTomatoService service;

    @PostMapping("/add")
    public R add(@RequestBody TimeTomatoDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        int flag = this.service.add(dto);
        return R.toAjax(flag);
    }
}
