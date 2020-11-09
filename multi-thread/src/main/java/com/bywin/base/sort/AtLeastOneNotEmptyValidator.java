package com.bywin.base.sort;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @author yeric
 * @date 2020/9/20 23:40
 */
public class AtLeastOneNotEmptyValidator implements ConstraintValidator<AtLeastOneNotEmpty, Object> {
    private String[] fields;

    @Override
    public void initialize(AtLeastOneNotEmpty atLeastOneNotEmpty) {
        this.fields = atLeastOneNotEmpty.fields();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        if (object == null) {
            return true;
        }
        try {
            String orderKey = null;
            String orderType = null;

            for (String fieldName : fields) {
                if ("orderKey".equals(fieldName)) {
                    orderKey = getField(object, fieldName);
                }
                if ("orderType".equals(fieldName)) {
                    orderType = getField(object, fieldName);
                }
            }
            if (!StringUtils.isBlank(orderKey)) {
                if (StringUtils.isBlank(orderType)) {
                    return false;
                }
                if (orderType.equalsIgnoreCase("asc") || orderType.equalsIgnoreCase("desc")) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getField(Object object, String fieldName) throws IllegalAccessException {
        if (object == null) {
            return null;
        }
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                Object o = field.get(object);
                if (o != null) {
                    return String.valueOf(o);
                }
                return null;
            }
        }
        return null;
    }
}
