package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {	
	public BooksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = "main-header")
	private WebElement txtHeaderPage;

	@FindBy(how = How.ID, using = "searchBox") 
	private WebElement txtSearchBox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"ReactTable\")]")
    private WebElement tblBooks;

	@FindBy(how = How.CLASS_NAME, using = "rt-noData")
	private WebElement txtNotFound;

	@FindBy(how = How.ID, using = "see-book-Git Pocket Guide")
	private WebElement lnkSelectedBook;

	@FindBy(how = How.XPATH, using = "//div[@class=\"rt-tr-group\"][1]//div[@class=\"rt-td\"]")
    private List <WebElement> tblBookColumns;

	public void type_SearchBox(String query) {
		txtSearchBox.sendKeys(query);
	}

	public void click_BookLink() {
		lnkSelectedBook.click();
	}

	public WebElement getHeader() {
        return txtHeaderPage;
    }

	public WebElement getTxtNotFound() {
		return txtNotFound;
	}

	public List <WebElement> getTblBookColumns() {
		return tblBookColumns;
	}
}
