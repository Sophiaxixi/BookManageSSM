package book.manage.mapper;

import lombok.Data;

import java.util.Date;

/**
 * @Author: shlin
 * @Date: 2023/1/7 - 01 - 07 - 10:09
 * @Description: book.manage.mapper
 * @Version: 1.0
 */
@Data
public class Borrow {
    int id;
    int bid;
    int sid;
    Date date;
}
