package com.sky.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录用户的数据传输对象
 * @author sky
 * @create 2020-10-30 21:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser implements Serializable {
    private static final long serialVersionUID=1L;

    private Long userId;

}
