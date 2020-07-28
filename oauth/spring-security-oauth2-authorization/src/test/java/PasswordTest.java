import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yeric
 * @date 2020/7/28 17:13
 */
public class PasswordTest {
    @Test
    public void password() {
        // 每次打印的结果都不一样，不影响
        System.out.println(new BCryptPasswordEncoder().encode("oauth2"));
    }
}
