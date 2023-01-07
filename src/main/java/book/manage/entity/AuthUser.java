package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2022/12/17 - 12 - 17 - 20:41
 * @Description: book.manage.entity
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class AuthUser {
    int id;
    String name;
    String role;
    String password;

}
