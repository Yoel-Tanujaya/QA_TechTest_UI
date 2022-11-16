package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectMenuPage {
    public SelectMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "main-header")
	private WebElement txtHeaderPage;
	
	@FindBy(how = How.ID, using = "withOptGroup") 
	private WebElement divSelectValue;

    @FindBy(how = How.ID, using = "react-select-2-option-3")
    private WebElement txtItemValue;

    @FindBy(how = How.XPATH, using = "//*[@id=\"withOptGroup\"]//div[contains(@class,\"singleValue\")]")
    private WebElement txtValue;

    @FindBy(how = How.ID, using = "selectOne")
    private WebElement divSelectOne;

    @FindBy(how = How.ID, using = "react-select-3-option-0-5")
    private WebElement txtItemOne;

    @FindBy(how = How.XPATH, using = "//*[@id=\"selectOne\"]//div[contains(@class,\"singleValue\")]")
    private WebElement txtOne;

    @FindBy(how = How.ID, using = "oldSelectMenu")
    private WebElement slcOldSelect;

    @FindBy(how = How.XPATH, using = "//*[text()=\"Select...\"]")
    private WebElement slcMultiSelect;
	
	public void click_SelectValue() {
		divSelectValue.click();
	}

    public void click_ValueItem() {
		txtItemValue.click();
	}

    public void click_SelectOne() {
		divSelectOne.click();
	}

    public void click_OneItem() {
		txtItemOne.click();
	}

    public void click_OldStyleMenu() {
        slcOldSelect.click();
    }

    public void click_MultiSelectMenu() {
        slcMultiSelect.click();
    }

    public WebElement getHeader() {
        return txtHeaderPage;
    }

    public WebElement getValueText() {
        return txtValue;
    }

    public WebElement getOneText() {
        return txtOne;
    }

    public WebElement getOldSelectMenu() {
        return slcOldSelect;
    }
}
