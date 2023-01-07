package book.manage.controller.api;

import book.manage.entity.AuthUser;
import book.manage.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

/**
 * @Author: shlin
 * @Date: 2023/1/7 - 01 - 07 - 10:32
 * @Description: book.manage.controller.page
 * @Version: 1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserApiController {
    @Resource
    BookService bookService;

    @RequestMapping(value = "/borrow-book",method = RequestMethod.GET)
    public String borrowBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")AuthUser user){
        bookService.borrowBook(bid,user.getId());
        return "redirect:/page/user/book";
    }

    @RequestMapping(value = "/return-book",method = RequestMethod.GET)
    public String returnBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")AuthUser user){
        bookService.returnBook(bid,user.getId());
        return "redirect:/page/user/book";
    }
}
