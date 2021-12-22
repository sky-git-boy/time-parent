package com.sky.feign;

import com.sky.config.feign.OAuth2FeignConfig;
import com.sky.dto.RemoteUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sky
 * @create 2021-12-22 16:23
 */
@FeignClient(name = "admin-service", configuration = OAuth2FeignConfig.class, path = "/user")
public interface UserServiceFeign {
    @PostMapping("/getUser")
    RemoteUserDTO getUserByPhone(@RequestParam String phone);
}
