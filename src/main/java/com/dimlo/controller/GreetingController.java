package com.dimlo.controller;

import com.dimlo.entity.Book;
import com.dimlo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class GreetingController {
//    List<Record> records = new FakeRecordDataImpl().getData();

    /*
    ???
    https://spring.io/guides/gs/validating-form-input/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
     */
    @Autowired
//    Can't autowire here for some reason
    private DbService dbService; // = new DbService();

    @GetMapping(path="/a")
    public @ResponseBody Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return dbService.getAllBooks();
    }


    @GetMapping("/all")
    public String showAllBooks(@RequestParam(required = false) Integer page, Model model) {
        //todo check the value to be an int or pass string

        Iterable<Book> allBooks = dbService.getAllBooks();
        List<Book> allBooksList = new ArrayList<>();
        allBooks.forEach(allBooksList::add);
        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(allBooksList);

        pagedListHolder.setPageSize(5);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
        model.addAttribute("page", page);


        //TODO: rewrite some logic here
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
        }
//        else {
//            pagedListHolder.setPage(0);
//        }

        model.addAttribute("books", pagedListHolder.getPageList());

//        model.addAttribute("books", dbService.getAllBooks());
        model.addAttribute("newbook", new Book(1900, false));

        //   PagedListHolder
        //   https://stackoverflow.com/questions/31883643/how-do-i-add-simple-pagination-for-spring-mvc
        // todo impl in template

        return "all";
    }

    @GetMapping("/markread")
    public String markRead(@RequestParam Integer id, @RequestParam(required = false) Integer page, RedirectAttributes redirectAttributes, Model model) {
        dbService.markRead(id);
        redirectAttributes.addAttribute("page", page);

        return "redirect:/all";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam int id, @RequestParam(required = false) Integer page, RedirectAttributes redirectAttributes, Model model) {
        dbService.deleteBook(id);
        redirectAttributes.addAttribute("page", page);
        return "redirect:/all";
    }

    @PostMapping("/add")
    public String addNewBook(@Valid Book book, BindingResult bindingResult, Model model) { // @ResponseBody  @ModelAttribute
//        Book newBook = new Book(book.getTitle(), book.getDescription(), book.getAuthor(), book.getIsbn(),
//                book.getPrintyear(), book.getReadalready());
//        return newBook.toString();
        if (!bindingResult.hasErrors()) {
            dbService.addNewBook(book);
        }

        model.addAttribute("books", dbService.getAllBooks());
        model.addAttribute("newbook", new Book(1900, false));

        return "redirect:/all";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam int id, Model model) {
        // page redirecting not done
        Book book = dbService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "updateform";
        } else {
//            model.addAttribute("books", dbService.getAllBooks());
//            model.addAttribute("newbook", new Book(dbService.getNextId()));

            return "redirect:/all";
        }
    }

    @PostMapping("/processupdate")
    public String processUpdate(@Valid Book book, BindingResult bindingResult, Model model) {  //@ModelAttribute

        if (!bindingResult.hasErrors()) {
            book.setReadalready(false);
            dbService.putBook(book);
        }

        model.addAttribute("books", dbService.getAllBooks());
        model.addAttribute("newbook", new Book(dbService.getNextId()));

        return "redirect:/all";
    }

    @PostMapping("/search")
    public String search(@RequestParam("stitle") String stitle,
                         @RequestParam("sdescription") String sdesc,
                         @RequestParam("sauthor") String sauthor, @RequestParam("sisbn") String sisbn,
                         @RequestParam("syearfrom") String syearfrom, @RequestParam ("syearto") String syearto, Model model) {

//        Some test stuff
//        return dbService.search(stitle, sdesc, sauthor, sisbn, syearfrom, syearto).toString();
//        return stitle + " " + sdesc + " " + sauthor + " " + sisbn + " " + syearfrom + " " + syearto;

//        TODO: implement hibernate search engine

        model.addAttribute("books", dbService.search(stitle, sdesc, sauthor, sisbn, syearfrom, syearto));

        return "searchresult";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "redirect:error";
    }

// @ModelAttribute
// @ResponseBody

}