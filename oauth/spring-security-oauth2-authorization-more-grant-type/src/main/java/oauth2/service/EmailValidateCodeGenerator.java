package oauth2.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yeric
 * @date 2020/7/29 16:10
 */
@Component
public class EmailValidateCodeGenerator implements ValidateCodeGenerator{
    @Override
    public String generate(ServletWebRequest request) {
        return RandomCode.random(6);
    }
}
