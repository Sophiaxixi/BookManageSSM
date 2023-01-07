package book.manage.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: shlin
 * @Date: 2023/1/7 - 01 - 07 - 15:08
 * @Description: book.manage.entity
 * @Version: 1.0
 */
@Data
public class BorrowDetails {
    int id;
    String sname;
    String title;
    Date date;
}
