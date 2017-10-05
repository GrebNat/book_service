package demo.book_service.storage;

import static java.lang.Math.abs;

import demo.book_service.entity.Book;
import demo.book_service.entity.Publisher;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Natalia_Grebenshchikova on 10/4/2017.
 */
public class BookStorage {

  public static Map<String, Book> books = new HashMap<>();

  public static Book create(Book book) {
    book.id = String.valueOf(abs(new Random().nextLong()));
    books.put(book.id, book);
    return book;
  }

  public static void fillBook() {
   create(new Book("Ovod", "Voinich", "1950", "1234567891230", new Publisher("Piter","Piter")));
  }
}
