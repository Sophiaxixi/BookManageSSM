package book.manage.controller.page;

import book.manage.service.AuthService;
import book.manage.service.BookService;
import book.manage.service.StateService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: shlin
 * @Date: 2023/1/5 - 01 - 05 - 22:08
 * @Description: book.manage.controller.page
 * @Version: 1.0
 */
@Controller
@RequestMapping("/page/admin")
public class AdminPageController {

    @Resource
    AuthService service;

    @Resource
    BookService bookService;

    @Resource
    StateService stateService;

    @RequestMapping( "/index")
    public String index(HttpSession session,Model model){
        model.addAttribute("user",service.findUser(session));
        model.addAttribute("borrowList",bookService.getBorrowDetailsList());
        model.addAttribute("globalState",stateService.getState());
        return "/admin/index";
    }

    @RequestMapping( "/book")
    public String book(HttpSession session,Model model){
        model.addAttribute("user",service.findUser(session));
        model.addAttribute("bookList",bookService.getAllBook());
        return "/admin/book";
    }

    @RequestMapping(value = "/add-book")
    String addBook(HttpSession session,Model model){
        model.addAttribute("user",service.findUser(session));
        return "/admin/add-book";
    }
}
