package com.sky.dto;

import com.sky.domain.SimpleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础的传输对象
 * @author sky
 * @create 2020-10-30 22:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 页码 默认1
     */
    private Integer pageNum = 1;

    /**
     * 每页显示条数 默认10
     */
    private Integer pageSize = 10;

    /**
     * 当前操作对象
     */
    private SimpleUser simpleUser;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}
