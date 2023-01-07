package book.manage.controller.api;

import book.manage.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author: shlin
 * @Date: 2023/1/6 - 01 - 06 - 15:54
 * @Description: book.manage.controller.api
 * @Version: 1.0
 */
@Controller
@RequestMapping("/api/admin")
public class AdminApiController {
    @Resource
    BookService bookService;

    @RequestMapping(value = "/del-book",method = RequestMethod.GET)
    String deleteBook(@RequestParam("bid") int bid){
        bookService.deleteBook(bid);
        return "redirect:/page/admin/index";
    }

    @RequestMapping(value = "/add-book",method = RequestMethod.POST)
    String addBook(@RequestParam("title") String title,
                   @RequestParam("descp") String descp,
                   @RequestParam("price") double price){
        bookService.addBook(title,descp,price);
        return "redirect:/page/admin/book";
    }

}
