package com.bywin.base.sort;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author yeric
 * @date 2020/9/20 23:37
 */
@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AtLeastOneNotEmptyValidator.class)
@Documented
public @interface AtLeastOneNotEmpty {
    String message() default "{至少有一个属性不可为空}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fields() default {"orderKey","orderType"};
}
