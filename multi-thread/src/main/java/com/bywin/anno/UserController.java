package com.bywin.anno;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/11
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("add")
    public UserDTO add(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(">>> 用户开户成功...");
        return userDTO;
    }


//    @PostMapping("add2")
//    public UserDTO add2(@RequestBody @Valid UserDTO userDTO) {
//        System.out.println(">>> 用户开户成功...");
//        return userDTO;
//    }
}