package oauth2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yeric
 * @date 2020/7/29 16:07
 */
@Component
@RequiredArgsConstructor
public class EmailValidateCodeProcessor extends AbstractValidateCodeProcessor {
    @Override
    protected void send(ServletWebRequest request, String validateCode) {
        System.out.println(request.getHeader("email") +
                "邮箱验证码发送成功，验证码为：" + validateCode);
    }
}
