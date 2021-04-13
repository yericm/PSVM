package com.bywin.anno;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description 自定义校验器
 * @Author Mr.nobody
 * @Date 2021/3/11
 * @Version 1.0
 */
public class IsLeekValidator implements ConstraintValidator<IsLeek, String> {

    // 是否强制校验
    private boolean required;

    @Override
    public void initialize(IsLeek constraintAnnotation) {
        System.out.println("你来自定哦校验逻辑了");
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            // 名字以"新韭菜"开头的则校验通过
            return !StringUtils.isEmpty(name) && name.startsWith("新韭菜");
        }
        return false;
    }
}