package com.darcardona.libraryu.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.darcardona.libraryu.domain.Book;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

public class BookRepositoryTest extends AbstractIntegrationTestConfig {

  @Rule
  public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("libraryu-test");

  // nosql-unit requirement
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  @UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
  @ShouldMatchDataSet(location = "/books.json")
  public void saveBook() {

    Book book = new Book();
    book.setIsbn("978-84-322-4821-4");
    book.setTitle("Palabra sobre palabra");
    book.setAuthor("Angel Gonzales");
    book.setReview("Uno de los más destacados representantes de la llamada generación del medio siglo");
    book.setEdition("Austral");
    bookRepository.save(book);

    book = new Book();
    book.setIsbn("978-958-8611-77-8");
    book.setTitle("La casa de los espiritus");
    book.setAuthor("Isabel Allende");
    book.setReview("Magistralmente ambientada en algún lugar de América Latina");
    book.setEdition("Debolsillo");
    bookRepository.save(book);

    book = new Book();
    book.setIsbn("978-958-8611-77-9");
    book.setTitle("El cuaderno de Maya");
    book.setAuthor("Isabel Allende");
    book.setReview("Magistralmente ambientada en algún lugar de América Central");
    book.setEdition("Debolsillo");
    bookRepository.save(book);

    book = new Book();
    book.setIsbn("978-987-45158-0-3");
    book.setTitle("Proyectos Ágiles con #Scrum");
    book.setAuthor("Martín Alaimo");
    book.setReview("Flexibilidad, aprendizaje, innovación y colaboración en contextos complejos");
    book.setEdition("Kleer");
    bookRepository.save(book);

    book = new Book();
    book.setIsbn("978-0-321-81573-6");
    book.setTitle("Software Architecture in Practice");
    book.setAuthor("Len Bass");
    book.setReview("Award-winning and highly influential");
    book.setEdition("Addison Wesley");
    bookRepository.save(book);
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void findBookByTitle() {
    List<Book> books = bookRepository.findByTitle("Palabra sobre palabra");
    assertThat(books).isNotNull();
    assertThat(books.size()).isEqualTo(1);
    assertThat(books.get(0)).isNotNull();
    assertThat(books.get(0).getAuthor()).isEqualTo("Angel Gonzales");
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void findBookByAutor() {
    List<Book> books = bookRepository.findByAuthor("Martín Alaimo");
    assertThat(books).isNotNull();
    assertThat(books.size()).isEqualTo(1);
    assertThat(books.get(0)).isNotNull();
    assertThat(books.get(0).getEdition()).isEqualTo("Kleer");
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void findBookByEdition() {
    List<Book> books = bookRepository.findByEdition("Debolsillo");
    assertThat(books).isNotNull();
    assertThat(books.size()).isEqualTo(2);
    assertThat(books.get(0)).isNotNull();
    assertThat(books.get(0).getAuthor()).isEqualTo("Isabel Allende");
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void countBooks() {
    long total = bookRepository.count();

    assertThat(total).isEqualTo(5);
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void updateCategories() {
    List<Book> books = bookRepository.findByTitle("Palabra sobre palabra");
    Book book = books.get(0);
    book.setAuthor("Ángel Gonzáles");
    bookRepository.save(book);

    List<Book> booksAfterUpdate = bookRepository.findByAuthor("Ángel Gonzáles");
    Book bookAfterUpdate = booksAfterUpdate.get(0);

    assertThat(bookRepository.count()).isEqualTo(5);
    assertThat(bookAfterUpdate.getId()).isEqualTo(book.getId());
  }

  @Test
  @UsingDataSet(locations = {"/books.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void deleteBook() {
    assertThat(bookRepository.count()).isEqualTo(5);

    List<Book> books = bookRepository.findByEdition("Austral");
    bookRepository.delete(books.get(0));

    assertThat(bookRepository.count()).isEqualTo(4);
  }

  @Test
  @UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
  public void repositoryShouldReturnEmpty() {
    List<Book> books = bookRepository.findAll();
    assertThat(books.size()).isEqualTo(0);
  }

}
