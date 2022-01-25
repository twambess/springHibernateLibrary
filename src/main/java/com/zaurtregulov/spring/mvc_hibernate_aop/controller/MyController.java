package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.ReaderDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Book;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Bookkeeping;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Reader;
import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.KeepingException;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.BookService;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.BookkeepingService;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private BookkeepingService bookkeepingService;



    @RequestMapping("/")
    public String showMenu() {
        return "menu";
    }    // MENU


    @Autowired
    private BookService bookService;    // SHOW BOOKS
    @RequestMapping("/showAllBooks")
    public  String showAllBooks(Model model){

        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "all-books";
    }



    @Autowired
    private ReaderService readerService;    //SHOW READERS
    @RequestMapping("/showAllReaders")
    public  String showAllReaders(Model model){

        List<Reader> allReaders = readerService.getAllReaders();
        model.addAttribute("allReaders", allReaders);
        return "all-readers";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/addNewBook" )  // NEW BOOK
    public String addNewBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-info";
    }

    @RequestMapping("/addNewReader" )        // NEW READER
    public String addNewReader(Model model){
        Reader reader = new Reader();
        model.addAttribute("reader", reader);
    return "reader-info";
    }

    @RequestMapping("/saveBook")    // SAVE BOOk
    public String saveBook(@ModelAttribute("book") Book book){

        bookService.saveBook(book);
        return "redirect:/";
    }

    @RequestMapping("/saveReader")    // SAVE READER
    public String saveReader(@ModelAttribute("reader") Reader reader){

        readerService.saveReader(reader);
        return "redirect:/";
    }

    @RequestMapping("/updateInfoBook")    //  UPDATE Book
    public String updateBook(@RequestParam("bookId") int id, Model model){


        Book book=bookService.getBook(id);
        model.addAttribute("book", book);
        return "book-info";

    }


    @RequestMapping("/updateInfo")    //  UPDATE READER
    public String updateReader(@RequestParam("readerId") int id, Model model){


        Reader reader=readerService.getReader(id);
        model.addAttribute("reader", reader);
        return "reader-info";

    }

    @RequestMapping("/deleteBook")  // DELETE BOOk
    public String deleteBook(@RequestParam("bookId") int id){

        bookService.deleteBook(id);
        return "redirect:/";
    }

    @RequestMapping("/deleteReader")     //DELETE READER
    public String deleteReader(@RequestParam("readerId") int id){

        readerService.deleteReader(id);
        return "redirect:/";
    }

    @RequestMapping("/showAllKeepings")
    public String showAllKeepings(Model model) {

        List<Bookkeeping> allKeepings = bookkeepingService.getAllKeepings();
        model.addAttribute("allKeepings", allKeepings);

        return "all-keepings";
    }

    @RequestMapping("/addNewKeeping")
    public String addNewKeeping(Model model) {

        Bookkeeping keeping = new Bookkeeping();
        model.addAttribute("keeping", keeping);
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        List<Reader> allReaders = readerService.getAllReaders();
        model.addAttribute("allReaders", allReaders);

        return "keeping-info";
    }

    @RequestMapping("/saveKeeping")
    public String saveKeeping(@Valid @ModelAttribute("keeping") Bookkeeping keeping,
                              BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<Book> allBooks = bookService.getAllBooks();
            model.addAttribute("allBooks", allBooks);
            List<Reader> allReaders = readerService.getAllReaders();
            model.addAttribute("allReaders", allReaders);
            return "keeping-info";
        } else {
            try {
                keeping.setReader(readerService.getReader(keeping.getReaderId()));
                keeping.setBook(bookService.getBook(keeping.getBookId()));
                bookkeepingService.saveKeeping(keeping);
            } catch (KeepingException e) {
                model.addAttribute("error", e);
                return "error";
            }
            return "redirect:/";
        }
    }

    @RequestMapping("/updateKeeping")
    public String updateKeeping(@RequestParam("keepingId") int id, Model model) {

        Bookkeeping keeping = bookkeepingService.getKeeping(id);
        model.addAttribute("keeping", keeping);

        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        List<Reader> allReaders = readerService.getAllReaders();
        model.addAttribute("allReaders", allReaders);

        return "keeping-info";
    }

    @RequestMapping("/deleteKeeping")
    public String deleteKeeping(@RequestParam("keepingId") int id) {

        bookkeepingService.deleteKeeping(id);

        return "redirect:/";
    }
}
