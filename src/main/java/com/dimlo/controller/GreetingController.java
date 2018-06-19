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

    @Autowired
    private DbService dbService;

    @GetMapping("/")
    public String start() {
    return "forward:all";    }


    @GetMapping("/all")
    public String showAllBooks(@RequestParam(required = false) Integer page, Model model) {
        //todo check the value to be an int or pass string

        PagedListHolder<Book> pagedListHolder = dbService.getPagedListHolder();

        pagedListHolder.setPageSize(10);

        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1)
            page = 1;
        if (page > pagedListHolder.getPageCount())
             page = pagedListHolder.getPageCount();

        pagedListHolder.setPage(page-1);
        model.addAttribute("page", page);
        model.addAttribute("books", pagedListHolder.getPageList());
        model.addAttribute("newbook", new Book(1900, false));

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

        if (!bindingResult.hasErrors()) {
            dbService.addNewBook(book);
        }

        return "redirect:/all";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam int id, Model model) {
        Book book = dbService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "updateform";
        } else {
            return "redirect:/all";
        }
    }

    @PostMapping("/processupdate")
    public String processUpdate(@Valid Book book, BindingResult bindingResult, Model model) {  //@ModelAttribute

        if (!bindingResult.hasErrors()) {
            book.setReadalready(false);
            dbService.putBook(book);
        }

        return "redirect:/all";
    }

    @PostMapping("/search")
    public String search(@RequestParam("stitle") String stitle,
                         @RequestParam("sdescription") String sdesc,
                         @RequestParam("sauthor") String sauthor, @RequestParam("sisbn") String sisbn,
                         @RequestParam("syearfrom") String syearfrom, @RequestParam ("syearto") String syearto, Model model) {

        model.addAttribute("books", dbService.search(stitle, sdesc, sauthor, sisbn, syearfrom, syearto));

        return "searchresult";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "redirect:error";
    }
}