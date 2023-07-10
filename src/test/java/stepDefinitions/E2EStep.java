package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.*;

public class E2EStep {
    private BaseStep baseStep = new BaseStep();
    private HomePage homePage;
    private DetailPage detailPage;
    private MiniCartPage miniCartPage;
    private CheckOutCartPage checkOutCartPage;
    private ShippingPage shippingPage;

    @When("^user scroll-down to choose the item$")
    public void user_scroll_down_to_choose_the_item() {
        homePage = new HomePage(baseStep.driver);
        homePage.scrollToSelectItem();
    }

    @And("^user navigate to the detail page and select info item$")
    public void user_navigate_to_the_detail_page_and_select_info_item() {
        detailPage = new DetailPage(baseStep.driver);
        detailPage.selectProductInfo();
    }

    @And("^user navigate to the check out page to payment$")
    public void user_navigate_to_the_check_out_page_to_payment() {
        miniCartPage = new MiniCartPage(baseStep.driver);
        checkOutCartPage = new CheckOutCartPage(baseStep.driver);
        shippingPage = new ShippingPage(baseStep.driver);

        miniCartPage.navigateToCheckOutCart();
        checkOutCartPage.checkOutAfterVerify();
        shippingPage.shipping();

    }

}
