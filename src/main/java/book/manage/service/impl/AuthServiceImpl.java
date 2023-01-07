package book.manage.service.impl;

import book.manage.entity.AuthUser;
import book.manage.mapper.UserMapper;
import book.manage.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: shlin
 * @Date: 2022/12/26 - 12 - 26 - 22:48
 * @Description: book.manage.service.impl
 * @Version: 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UserMapper mapper;

    @Transactional
    @Override
    public Boolean register(String username, String sex, String grade, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthUser user = new AuthUser(0,username,"user",encoder.encode(password));
        if(mapper.registerUser(user)<=0)
            throw new RuntimeException("用户信息添加失败！");
        if(mapper.addStudentInfo(user.getId(),username,sex,grade)<=0)
            throw new RuntimeException("学生信息录入失败！");

        return false;
    }
    @Override
    public AuthUser findUser(HttpSession session){
        AuthUser user = (AuthUser) session.getAttribute("user");
        if(user==null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user",user);
        }
        return user;
    }
}
