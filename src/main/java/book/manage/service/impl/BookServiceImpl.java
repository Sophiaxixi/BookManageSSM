package book.manage.service.impl;

import book.manage.entity.Book;
import book.manage.entity.BorrowDetails;
import book.manage.mapper.BookMapper;
import book.manage.mapper.Borrow;
import book.manage.mapper.UserMapper;
import book.manage.service.BookService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: shlin
 * @Date: 2023/1/6 - 01 - 06 - 15:22
 * @Description: book.manage.service.impl
 * @Version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper mapper;
    @Resource
    UserMapper userMapper;
    @Override
    public List<Book> getAllBook() {
        return mapper.getAllBook();
    }

    @Override
    public List<Book> getAllBookWithoutBorrow() {
        List<Book> books = mapper.getAllBook();
        List<Integer> borrows = mapper.getBorrowList()
                .stream()
                .map(borrow->borrow.getBid())
                .collect(Collectors.toList());
        //已经接走的就过滤掉
        return books.stream()
                .filter(book -> !borrows.contains(book.getBid())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBorrowedBookById(int id) {
        Integer sid = userMapper.getSidByUserId(id);
        if(sid==null) return Collections.EMPTY_LIST;
        return mapper.borrowListBySid(sid)
                .stream()
                .map(borrow ->
                     mapper.getBookById(borrow.getBid())
                )
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(int bid) {
        mapper.deleteBook(bid);
    }

    @Override
    public void addBook(String title, String descri, double price) {
        mapper.addBook(title,descri,price);
    }

    @Override
    public void borrowBook(int bid, int id) {
        Integer sid = userMapper.getSidByUserId(id);
        if(sid==null) return;
        mapper.addBorrow(bid,sid);
    }

    @Override
    public void returnBook(int bid, int id) {
        Integer sid = userMapper.getSidByUserId(id);
        if(sid==null) return;
        mapper.deleteBorrow(bid,sid);
    }

    @Override
    public List<BorrowDetails> getBorrowDetailsList() {
        return mapper.borrowDetailsList();
    }
}
