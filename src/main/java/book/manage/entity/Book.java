package book.manage.entity;

import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2023/1/6 - 01 - 06 - 15:18
 * @Description: book.manage.entity
 * @Version: 1.0
 */
@Data
public class Book {
    int bid;
    String title;
    String descp;
    double price;
}
