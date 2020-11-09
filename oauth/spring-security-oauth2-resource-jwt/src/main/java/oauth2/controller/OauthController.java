package oauth2.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author yeric
 * @date 2020/7/29 11:35
 */
@RestController
@RequestMapping("/auth")
public class OauthController {

    /**
     * 获取当前登录的用户信息
     *
     * @param principal 用户信息
     * @return http 响应
     */
    @GetMapping("/me")
    public HttpEntity<?> oauthMe(Principal principal) {
        return ResponseEntity.ok(principal);
    }
    @GetMapping("/me1")
    public HttpEntity<?> oauthMe1(Principal principal) {
        return ResponseEntity.ok("我是受保护的资源----");
    }
}
