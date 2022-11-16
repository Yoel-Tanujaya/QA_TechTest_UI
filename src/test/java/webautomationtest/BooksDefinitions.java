package webautomationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import object.Books;

public class BooksDefinitions {
  private static String DRIVER_PATH = "/Users/yoeltan/Documents/";
  private static String BASE_URL = "https://demoqa.com/books";
  private final WebDriver driver = new ChromeDriver();
  private String bookName = "Git Pocket Guide";

  private Books book;

  @Given("User go to books page")
  public void User_go_to_books_page() {
    System.setProperty("webdriver.chrome.driver",DRIVER_PATH+"chromedriver");
		driver.manage().window().maximize();
    driver.get(BASE_URL);
  }

  @When("User in “Book Store” page")
  public void User_in_Book_Store_page() {
    WebElement headerPage = driver.findElement(By.className("main-header"));
    assertEquals("Book Store", headerPage.getText());
  }

  @When("User search book “qa engineer”")
  public void User_search_book_qa_engineer() {
    WebElement searchBox = driver.findElement(By.id("searchBox"));
    searchBox.sendKeys("qa engineer");
  }

  @Then("User see “No rows found”")
  public void User_see_No_rows_found() {
    WebElement table = driver.findElement(By.xpath("//div[contains(@class,\"ReactTable\")]"));
    assertEquals(true, table.findElement(By.className("rt-noData")).isDisplayed());
  }

  @When("User search book “Git Pocket Guide”")
  public void User_search_book_Git_Pocket_Guide() {
    WebElement searchBox = driver.findElement(By.id("searchBox"));
    searchBox.sendKeys(bookName);
  }

  @When("User click book “Git Pocket Guide”")
  public void User_click_book_Git_Pocket_Guide() {
    WebElement gitBookLink = driver.findElement(By.id("see-book-"+bookName));
    List <WebElement> col = driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"][1]//div[@class=\"rt-td\"]"));

    book = new Books(gitBookLink.getText(), col.get(2).getText(), col.get(3).getText());
    gitBookLink.click();
  }

  @Then("User see “Git Pocket Guide”")
  public void User_see_Git_Pocket_Guide() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]"))));
    Books assertBooks = new Books(
      driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]//*[@id=\"userName-value\"]")).getText(),
      driver.findElement(By.xpath("//*[@id=\"author-wrapper\"]//*[@id=\"userName-value\"]")).getText(),
      driver.findElement(By.xpath("//*[@id=\"publisher-wrapper\"]//*[@id=\"userName-value\"]")).getText()
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
