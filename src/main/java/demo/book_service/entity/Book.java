package demo.book_service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Natalia_Grebenshchikova on 10/3/2017.
 */
public class Book {

  public Book() {  }

  public Book(String title, String author, String year, String isbn,
      Publisher publisher) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.isbn = isbn;
    this.publisher = publisher;
  }

  public String id;

  @NotNull
  public String title;

  public String author;

  @NotNull
  @Pattern(regexp = "[0-9]{4}")
  public String year;

  @NotNull
  @Pattern(regexp = "[0-9]{13}|[0-9]{13}")
  public String isbn;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Publisher publisher;
}
