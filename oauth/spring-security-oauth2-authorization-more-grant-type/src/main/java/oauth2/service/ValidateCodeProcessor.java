package oauth2.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yeric
 * @date 2020/7/29 16:05
 */
public interface ValidateCodeProcessor {

    /**
     * 创建验证码
     *
     * @param request 请求
     * @throws Exception 异常
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 验证验证码
     *
     * @param request 请求
     */
    void validate(ServletWebRequest request);

}

