package oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;
import java.util.Objects;

/**
 * @author yeric
 * @date 2020/7/29 16:05
 */
public abstract class AbstractValidateCodeProcessor implements ValidateCodeProcessor {
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;
    @Autowired
    private ValidateCodeRepository validateCodeRepository;
    @Override
    public void create(ServletWebRequest request) throws Exception {
        String validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    @Override
    public void validate(ServletWebRequest request) {

    }


    /**
     * 发送验证码，由子类实现
     *
     * @param request      请求
     * @param validateCode 验证码
     */
    protected abstract void send(ServletWebRequest request, String validateCode);

    /**
     * 保存验证码，保存到 redis 中
     *
     * @param request      请求
     * @param validateCode 验证码
     */
    private void save(ServletWebRequest request, String validateCode) {
        validateCodeRepository.save(request,validateCode,getValidateCodeType(request));
    }

    /**
     * 生成验证码
     *
     * @param request 请求
     * @return 验证码
     */
    private String generate(ServletWebRequest request) {
        String type = getValidateCodeType(request);
        String componentName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator generator = validateCodeGenerators.get(componentName);
        if (Objects.isNull(generator)) {
            throw new RuntimeException("验证码生成器 " + componentName + " 不存在。");
        }
        return generator.generate(request);    }
    /**
     * 根据请求 url 获取验证码类型
     *
     * @return 结果
     */
    private String getValidateCodeType(ServletWebRequest request) {
        String uri = request.getRequest().getRequestURI();
        int index = uri.lastIndexOf("/") + 1;
        return uri.substring(index).toLowerCase();
    }
}
