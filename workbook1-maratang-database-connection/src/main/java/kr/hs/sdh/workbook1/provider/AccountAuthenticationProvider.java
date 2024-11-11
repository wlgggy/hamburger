package kr.hs.sdh.workbook1.provider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AccountAuthenticationProvider extends DaoAuthenticationProvider {

    public AccountAuthenticationProvider() {
        super.hideUserNotFoundExceptions = false;
    }
}
