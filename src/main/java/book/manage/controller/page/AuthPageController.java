package book.manage.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: shlin
 * @Date: 2022/12/14 - 12 - 14 - 23:42
 * @Description: book.manage.controller
 * @Version: 1.0
 */
@Controller
@RequestMapping("/page/auth")
public class AuthPageController {

    @RequestMapping("/login")
    public String login(){ return "login";}

    @RequestMapping("/register")
    public String register(){return "register";}

}
