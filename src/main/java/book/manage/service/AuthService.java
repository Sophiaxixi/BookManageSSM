package book.manage.service;

import book.manage.entity.AuthUser;
import book.manage.mapper.UserMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: shlin
 * @Date: 2022/12/26 - 12 - 26 - 22:48
 * @Description: book.manage.service
 * @Version: 1.0
 */
public interface AuthService {

    Boolean register(String username, String sex, String grade, String password);

    AuthUser findUser(HttpSession session);



}
