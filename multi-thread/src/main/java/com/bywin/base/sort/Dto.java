package com.bywin.base.sort;

import lombok.Data;

/**
 * @author yeric
 * @date 2020/9/20 23:48
 */
@Data
@AtLeastOneNotEmpty
public class Dto {
    private String orderKey;
    private String orderType;
}
