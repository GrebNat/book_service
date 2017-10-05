package demo.book_service.entity;

import javax.validation.constraints.NotNull;

/**
 * Created by Natalia_Grebenshchikova on 10/4/2017.
 */
public class Publisher {

  public Publisher(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public Publisher() {
  }

  @NotNull
  public String name;

  public String city;

}

