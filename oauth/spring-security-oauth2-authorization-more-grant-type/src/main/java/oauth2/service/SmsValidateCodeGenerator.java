package oauth2.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yeric
 * @date 2020/7/29 16:09
 */
@Component
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {
    @Override
    public String generate(ServletWebRequest request) {
        // 定义手机验证码生成策略，可以使用 request 中从请求动态获取生成策略
        // 可以从配置文件中读取生成策略
        return RandomCode.random(4, true);
    }
}
