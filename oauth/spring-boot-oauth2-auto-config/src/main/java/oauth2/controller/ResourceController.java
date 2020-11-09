package oauth2.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author yeric
 * @date 2020/7/28 01:00
 */
@RestController
public class ResourceController {
    /**
     * 获取当前登陆用户的信息
     * @param principal 当前的登陆用户
     * @return
     */
    @GetMapping("/resource")
    public HttpEntity resource (Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
