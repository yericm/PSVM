package oauth2.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.time.Duration;

/**
 * @author yeric
 * @date 2020/7/28 09:47
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final @NonNull
    AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        builder
                // 构建一个 id 为 oauth2 的客户端
                .withClient("oauth2")
                // 设置她的密钥，加密后的
                .secret("$2a$10$H14LpOP/9PpJImpIlYoSI.YRZtwy4R7xgjREwYXS.h/8RcvLe75CG")
                // 设置允许访问的资源 id
                .resourceIds("oauth2")
                // 授权的类型
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                // 可以授权的角色
                .authorities("ROLE_ADMIN", "ROLE_USER")
                // 授权的范围
                .scopes("all")
                // token 有效期
                .accessTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                // 刷新 token 的有效期
                .refreshTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                // 授权码模式的重定向地址
                .redirectUris("http://example.com");

    }



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(this.authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    /**
     * 令牌转换器，非/对称密钥加密
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //  对称密钥加密
        //  converter.setSigningKey("oauth2");
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource("oauth2.jks"), "oauth2".toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2"));
        return converter;
    }

    /**
     * token store 实现
     *
     * @return JwtTokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }


}
