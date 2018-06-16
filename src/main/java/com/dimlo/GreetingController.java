package com.dimlo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String showAllBooks(Model model) {
        model.addAttribute("books", dbService.getAllBooks());
        model.addAttribute("newbook", new Book(1900, false));
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
        Book book = dbService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "updateform";
        } else {
            model.addAttribute("books", dbService.getAllBooks());
            model.addAttribute("newbook", new Book(dbService.getNextId()));

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
    public @ResponseBody String search(@RequestParam("stitle") String stitle,
                         @RequestParam("sdescription") String sdesc,
                         @RequestParam("sauthor") String sauthor, @RequestParam("sisbn") String sisbn,
                         @RequestParam("syearfrom") String syearfrom, @RequestParam ("syearto") String syearto) {
        return stitle + " " + sdesc + " " + sauthor + " " + sisbn + " " + syearfrom + " " + syearto;
//        return "redirect:/all";
    }




//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }


//    @GetMapping("/table")
//    public String table(@RequestParam(name="name", required=false, defaultValue="Somebody") String name,
//                        @RequestParam(name="age", required=false, defaultValue="0") String age,
//                        //throwing error when not an int value passed
//                        @RequestParam(name="profession", required=false, defaultValue="Blogger") String profession,
//                        Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        model.addAttribute("profession", profession);
//        return "table";
//    }


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