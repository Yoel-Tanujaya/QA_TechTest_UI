package webautomationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class SelectMenuDefinitions {
  private static String DRIVER_PATH = "/Users/yoeltan/Documents/";
  private static String BASE_URL = "https://demoqa.com/select-menu";
  private final WebDriver driver = new ChromeDriver();

  @Given("user go to homepage")
  public void user_go_to_homepage() {
    System.setProperty("webdriver.chrome.driver",DRIVER_PATH+"chromedriver");
		driver.manage().window().maximize();
    driver.get(BASE_URL);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }

  @When("user in “select menu” page")
  public void user_in_select_menu_page() {
    WebElement headerPage = driver.findElement(By.className("main-header"));
    assertEquals("Select Menu", headerPage.getText());
  }

  @When("user choose select value “Another root option”")
  public void user_choose_select_value_Another_root_option() {
    WebElement selectValueContainer = driver.findElement(By.id("withOptGroup"));
    selectValueContainer.click();

    WebElement valueDropdown = selectValueContainer.findElement(By.id("react-select-2-option-3"));
    valueDropdown.click();

    WebElement valueText = driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]//div[contains(@class,\"singleValue\")]"));
    assertEquals("Another root option", valueText.getText());
  }

  @When("user choose select one “Other”")
  public void user_choose_select_one_Other() {
    WebElement selectOneContainer = driver.findElement(By.id("selectOne"));
    selectOneContainer.click();

    WebElement oneDropdown = selectOneContainer.findElement(By.id("react-select-3-option-0-5"));
    oneDropdown.click();

    WebElement oneText = driver.findElement(By.xpath("//*[@id=\"selectOne\"]//div[contains(@class,\"singleValue\")]"));
    assertEquals("Other", oneText.getText());
  }

  @When("user choose old style select menu “Aqua”")
  public void user_choose_old_style_select_menu_Aqua() {
		Select selectMenu = new Select(driver.findElement(By.id("oldSelectMenu")));
		selectMenu.selectByVisibleText("Aqua");
    assertEquals(selectMenu.getFirstSelectedOption().getText(), "Aqua");
  }

  @When("user choose multi select drop down “all color”")
  public void user_choose_multi_select_drop_down_all_color() {
    String[] color = {"","","",""};
    WebElement multiSelectMenu = driver.findElement(By.xpath("//*[text()=\"Select...\"]"));
    multiSelectMenu.click();

    for(int i=0; i<4; i++) {
      WebElement multiDropdown = driver.findElement(By.id("react-select-4-option-"+i));
      color[i] = multiDropdown.getText();
      multiDropdown.click();
    }

    for(int i=0; i<4; i++) {
      WebElement multiValue = driver.findElement(By.xpath("(//*[contains(@class,\"multiValue\")])["+(i+1)+"]"));
      assertEquals(multiValue.getText(), color[i]);
    }
  }

  @Then("user success input all select menu")
  public void user_success_input_all_select_menu() throws InterruptedException {
    Thread.sleep(1000);
    driver.quit();
  }

  @After
  public void close() {
    driver.quit();
  }
}
