package oauth2.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @date 2020/7/29 16:17
 */
@Component
@RequiredArgsConstructor
public class ValidateCodeRepositoryImpl implements ValidateCodeRepository {

    private final @NonNull
    RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(ServletWebRequest request, String code, String type) {
        redisTemplate.opsForValue().set(buildKey(request, type), code,
                //  有效期可以从配置文件中读取或者请求中读取
                Duration.ofMinutes(10).getSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public String get(ServletWebRequest request, String type) {
        return redisTemplate.opsForValue().get(buildKey(request, type));
    }

    @Override
    public void remove(ServletWebRequest request, String type) {
        redisTemplate.delete(buildKey(request, type));
    }

    private String buildKey(ServletWebRequest request, String type) {
        String deviceId = request.getHeader(type);
        if (StringUtils.isEmpty(deviceId)) {
            throw new RuntimeException("请求中不存在邮箱号");
        }
        return "code:" + type + ":" +  deviceId;
    }
}
