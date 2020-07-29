package oauth2.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yeric
 * @date 2020/7/29 16:08
 */
public interface ValidateCodeGenerator {
    /**
     * 生成验证码
     *
     * @param request 请求
     * @return 生成结果
     */
    String generate(ServletWebRequest request);
}
