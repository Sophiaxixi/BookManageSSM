package book.manage.mapper;

import book.manage.entity.Book;
import book.manage.entity.BorrowDetails;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: shlin
 * @Date: 2023/1/6 - 01 - 06 - 15:16
 * @Description: book.manage.mapper
 * @Version: 1.0
 */
@Mapper
public interface BookMapper {
    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "bname",property = "title"),
            @Result(column = "descrip",property = "descp"),
            @Result(column = "price",property = "price")
    })
    @Select("select * from book")
    List<Book> getAllBook();

    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "bname",property = "title"),
            @Result(column = "descrip",property = "descp"),
            @Result(column = "price",property = "price")
    })
    @Select("select * from book where bid = #{bid}")
    Book getBookById(int bid);

    @Delete("delete from book where bid = #{bid}")
    void deleteBook(int bid);

    @Delete("delete from borrow where bid = #{bid} and sid=#{sid}")
    void deleteBorrow(@Param("bid") int bid,@Param("sid") int sid);


    @Insert("insert into book(bname,descrip,price) values(#{bname},#{descrip},#{price})")
    void addBook(@Param("bname") String bname, @Param("descrip") String descrip,@Param("price") double price);

    @Insert("insert into borrow(bid,sid,`time`) values(#{bid},#{sid},NOW())")
    void addBorrow(@Param("bid") int bid,@Param("sid") int sid);

    @Select("select * from borrow")
    List<Borrow> getBorrowList();

    @Select("select * from borrow where sid = #{sid}")
    List<Borrow> borrowListBySid(int sid);

    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "sname"),
            @Result(column = "bname",property = "title"),
            @Result(column = "time",property = "date")
    })
    @Select("SELECT * FROM borrow LEFT JOIN book on borrow.bid=book.bid left JOIN student on borrow.sid = student.sid")
    List<BorrowDetails> borrowDetailsList();

    @Select("select count(*) from borrow")
    int borrowCount();

    @Select("select count(*) from book")
    int bookCount();



}
