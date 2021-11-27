package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 构造菜单返回给前台的 vo
 * @author sky
 * @create 2020-10-30 22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeVo {
    private String id;

    private String serPath;//菜单表里面的url

    private boolean show = true; //是否显示

    public MenuTreeVo(String id, String serPath) {
        this.id = id;
        this.serPath = serPath;
    }
}