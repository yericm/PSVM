package com.bywin.design_patterns.chapater8;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created by yeric on 2019/8/15
 */
@Data
@AllArgsConstructor
public class MenuItem {
    /**
     * 菜名
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 价格
     */
    private Double price;
}
