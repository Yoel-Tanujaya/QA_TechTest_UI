package webautomationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import object.Books;
import pages.BooksDetailPage;
import pages.BooksPage;;

public class BooksSteps {
  // Change this to correct driver path on your system
  private static String DRIVER_PATH = "/Users/yoeltan/Documents/chromedriver";
  private static String BASE_URL = "https://demoqa.com/books";
  private final WebDriver driver = new ChromeDriver();
  
  private String bookName = "Git Pocket Guide";
  private Books book;

  @Given("User go to books page")
  public void User_go_to_books_page() {
    System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
		driver.manage().window().maximize();
    driver.get(BASE_URL);
  }

  @When("User in “Book Store” page")
  public void User_in_Book_Store_page() {
    BooksPage booksPage = new BooksPage(driver);
    assertEquals("Book Store", booksPage.getHeader().getText());
  }

  @When("User search book “qa engineer”")
  public void User_search_book_qa_engineer() {
    BooksPage booksPage = new BooksPage(driver);
    booksPage.type_SearchBox("qa engineer");
  }

  @Then("User see “No rows found”")
  public void User_see_No_rows_found() {
    BooksPage booksPage = new BooksPage(driver);
    assertEquals(true, booksPage.getTxtNotFound().isDisplayed());
  }

  @When("User search book “Git Pocket Guide”")
  public void User_search_book_Git_Pocket_Guide() {
    BooksPage booksPage = new BooksPage(driver);
    booksPage.type_SearchBox(bookName);
  }

  @When("User click book “Git Pocket Guide”")
  public void User_click_book_Git_Pocket_Guide() {
    BooksPage booksPage = new BooksPage(driver);
    book = new Books(
      booksPage.getTblBookColumns().get(1).getText(),
      booksPage.getTblBookColumns().get(2).getText(),
      booksPage.getTblBookColumns().get(3).getText()
    );
    booksPage.click_BookLink();
  }

  @Then("User see “Git Pocket Guide”")
  public void User_see_Git_Pocket_Guide() {
    BooksDetailPage booksDetailPage = new BooksDetailPage(driver);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(booksDetailPage.getTxtTitle()));
    Books assertBooks = new Books(
      booksDetailPage.getTxtTitle().getText(),
      booksDetailPage.getTxtAuthor().getText(),
      booksDetailPage.getTxtPublisher().getText()
    );
    assertEquals(assertBooks.getTitle(), book.getTitle());
    assertEquals(assertBooks.getAuthor(), book.getAuthor());
    assertEquals(assertBooks.getPublisher(), book.getPublisher());
  }

  @After
  public void close() throws InterruptedException {
    Thread.sleep(1000);
    driver.quit();
  }
}
