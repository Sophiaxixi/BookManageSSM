package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2023/1/7 - 01 - 07 - 15:30
 * @Description: book.manage.entity
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class GlobalState {
    int borrowCount;
    int bookCount;
    int studentCount;
}
