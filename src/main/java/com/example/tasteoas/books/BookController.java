package com.example.tasteoas.books;

import java.util.Collection;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

  @GetMapping("/{id}")
  public Book findById(@PathVariable long id) {
    return Book.builder()
        .id(id)
        .isbn("1234-5678-0912-345")
        .title("Anna calelina")
        .build();
  }

  @GetMapping("/")
  public Collection<Book> findBooks() {
    return Collections.emptyList();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Book updateBook(
      @PathVariable("id") final String id,
      @RequestBody final Book book
  ) {
    return book;
  }

}
