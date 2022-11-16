package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BooksDetailPage {	
	public BooksDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = "main-header")
	private WebElement txtHeaderPage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"title-wrapper\"]//*[@id=\"userName-value\"]")
    private WebElement txtTitle;

	@FindBy(how = How.XPATH, using = "//*[@id=\"author-wrapper\"]//*[@id=\"userName-value\"]")
    private WebElement txtAuthor;

	@FindBy(how = How.XPATH, using = "//*[@id=\"publisher-wrapper\"]//*[@id=\"userName-value\"]")
    private WebElement txtPublisher;

	public WebElement getTxtTitle() {
		return txtTitle;
	}

	public WebElement getTxtAuthor() {
		return txtAuthor;
	}

	public WebElement getTxtPublisher() {
		return txtPublisher;
	}
}
