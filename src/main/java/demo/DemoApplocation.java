package demo;

import static demo.book_service.storage.BookStorage.fillBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Natalia_Grebenshchikova on 7/21/2017.
 */
@EnableSwagger2
@SpringBootApplication
public class DemoApplocation {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplocation.class, args);
    fillBook();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
        "My REST API",
        "Some custom description of API.",
        "API TOS",
        "Terms of service",
        "myeaddress@company.com",
        "License of API",
        "API license URL");
    return apiInfo;
  }
}
