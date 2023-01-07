package book.manage.service;

import book.manage.entity.Book;
import book.manage.entity.BorrowDetails;
import book.manage.mapper.Borrow;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shlin
 * @Date: 2023/1/6 - 01 - 06 - 15:20
 * @Description: book.manage.service
 * @Version: 1.0
 */
public interface BookService {
    List<Book> getAllBook();
    List<Book> getAllBookWithoutBorrow();
    List<Book> getAllBorrowedBookById(int id);
    void deleteBook(int bid);
    void addBook(String title,String descri,double price);

    void borrowBook(int bid,int id);

    void returnBook(int bid, int sid);

    List<BorrowDetails> getBorrowDetailsList();



}
