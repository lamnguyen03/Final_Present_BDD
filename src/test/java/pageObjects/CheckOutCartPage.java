package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCartPage extends BasePage {

    private WebDriver driver;

    public CheckOutCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//main[@id='maincontent']//strong[@class='product-item-name']/a")
    private WebElement productName;

    @FindBy(xpath = "//td[@class='col price']")
    private WebElement productPrice;

    @FindBy(xpath = "//span[@class='base']")
    private WebElement titleOfCheckOutPage;

    @FindBy(xpath = "//li[@class='item']/button")
    private WebElement processToCheckoutBtn;

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public boolean isAtCheckOutCartPage() {
        waitToBeAvailable(titleOfCheckOutPage);
        return titleOfCheckOutPage.isDisplayed();
    }

    public CheckOutCartPage checkOutAfterVerify() {
        processToCheckoutBtn.click();
        return this;
    }
}
