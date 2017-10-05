package demo.book_service;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import demo.book_service.entity.Book;
import demo.book_service.storage.BookStorage;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Natalia_Grebenshchikova on 7/21/2017.
 */

@RestController
@RequestMapping(value = "/book", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class BookController {

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Book createBook(@RequestBody @Valid Book book){
        return BookStorage.create(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Book getBook(@PathVariable("id") String bookId, @RequestParam(value = "notShow", required = false) String notShow){
        Book book = BookStorage.books.get(bookId);
        if (notShow != null) {
            switch (notShow) {
                case "publisher":
                    book.publisher = null;
                    break;
            }
        }

        return book;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Book updateBook(@PathVariable("id") String bookId, @RequestBody @Valid Book newBook){
        BookStorage.books.replace(bookId, newBook);
        return newBook;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Book[] getBooks(){
        return BookStorage.books.values().toArray(new Book[]{});
    }
}
