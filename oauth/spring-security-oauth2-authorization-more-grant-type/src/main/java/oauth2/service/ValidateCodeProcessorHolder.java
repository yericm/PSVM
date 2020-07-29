package oauth2.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author yeric
 * @date 2020/7/29 16:19
 */
@Component
@RequiredArgsConstructor
public class ValidateCodeProcessorHolder {
    private final @NonNull
    Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 通过验证码类型查找
     *
     * @param type 验证码类型
     * @return 验证码处理器
     */
    ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (Objects.isNull(processor)){
            throw new RuntimeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }

}
