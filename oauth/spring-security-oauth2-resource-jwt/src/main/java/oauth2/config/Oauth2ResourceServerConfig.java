package oauth2.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author yeric
 * @date 2020/7/29 11:36
 */
@EnableResourceServer
@Configuration
@RequiredArgsConstructor
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @NonNull
    private ResourceServerProperties resourceServerProperties;
    /**
     * 远程服务
     */
    @NonNull
    private  RemoteTokenServices remoteTokenServices;
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        remoteTokenServices.setAccessTokenConverter(jwtAccessTokenConverter());
        // 设置资源服务器的 id
        resources.resourceId(resourceServerProperties.getResourceId());
//        .tokenServices(remoteTokenServices);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("oauth2");
        return converter;
    }

}
