package com.dimlo.controller;

import com.dimlo.entity.Book;
import com.dimlo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
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
//    @Autowired
//    Can't autowire here for some reason
    private DbService dbService = new DbService();


    @GetMapping("/all")
    public String showAllBooks(Model model) {
        model.addAttribute("books", dbService.getAllBooks());
        return "all";
    }

    @GetMapping("/markread")
    public String markRead(@RequestParam int id, Model model) {
        dbService.markRead(id);
        model.addAttribute("books", dbService.getAllBooks());
        return "redirect:/all";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam int id, Model model) {
        dbService.deleteBook(id);
        model.addAttribute("books", dbService.getAllBooks());
        return "redirect:/all";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam int id, Model model) {
        model.addAttribute("book", dbService.getBookById(id));
        return "updateform";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/table")
    public String table(@RequestParam(name="name", required=false, defaultValue="Somebody") String name,
                        @RequestParam(name="age", required=false, defaultValue="0") String age,
                        //throwing error when not an int value passed
                        @RequestParam(name="profession", required=false, defaultValue="Blogger") String profession,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("profession", profession);
        return "table";
    }

    @PostMapping("/processupdate")
    public String processUpdate(@ModelAttribute Book book, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors())
            dbService.putBook(book);

            model.addAttribute("books", dbService.getAllBooks());

        return "redirect:/all";
    }

//    @GetMapping("/dbcheck")
//    public String dbcheck(Model model) {
//
//        model.addAttribute("response", records);
//        model.addAttribute("record", new Record());
//        return "dbcheck";
//    }

//    @PostMapping("/dbcheck")
//    public String submitRecord(@Valid Record record, BindingResult bindingResult, Model model) {
    ///    @ModelAttribute
//        if (!bindingResult.hasErrors())
//            records.add(record);
//
//        model.addAttribute("response", records);
//
//        return "redirect:/dbcheck";
//        //Atother view and "back" button
//    }

}