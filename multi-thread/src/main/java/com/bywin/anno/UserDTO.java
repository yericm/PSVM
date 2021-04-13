package com.bywin.anno;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/11
 * @Version 1.0
 */
@Data
public class UserDTO {

    @NotBlank(message = "姓名不能为空")
    @IsLeek // 我们自定义的注解
    private String name;

    @Min(value = 18, message = "年龄不能小于18")
    private int age;

    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}