package com.bywin.download.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * created by yeric on 2019/8/12 22:48
 */
@Controller
public class PageController {

    @GetMapping("staticHtml")
    public String staticHtml () {
        return "download";
    }
}
