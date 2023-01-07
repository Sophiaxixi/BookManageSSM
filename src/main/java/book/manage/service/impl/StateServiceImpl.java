package book.manage.service.impl;

import book.manage.entity.GlobalState;
import book.manage.mapper.BookMapper;
import book.manage.mapper.UserMapper;
import book.manage.service.StateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: shlin
 * @Date: 2023/1/7 - 01 - 07 - 15:32
 * @Description: book.manage.service.impl
 * @Version: 1.0
 */
@Service
public class StateServiceImpl implements StateService {

    @Resource
    BookMapper bookMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public GlobalState getState() {
        return new GlobalState(bookMapper.borrowCount(), bookMapper.bookCount(), userMapper.studentCount());
    }
}
