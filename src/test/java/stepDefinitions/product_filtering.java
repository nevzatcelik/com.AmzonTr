package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HamburgerMenu;
import pages.HomePage;
import pages.NotebookPage;
import utils.Driver;

import java.time.Duration;

public class product_filtering {
    HomePage homePage=new HomePage();
    HamburgerMenu hamburgerMenu=new HamburgerMenu();

    NotebookPage notebookPage=new NotebookPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Then("the user navigates to all product hamburger menu on the left corner")
    public void the_user_navigates_to_all_product_hamburger_menu_on_the_left_corner() {
        homePage.cookie.click();
        homePage.hamburgerMenu.click();
    }
    @Then("the user clicks computers on the hamburger menu")
    public void the_user_click_pcomputer_on_the_hamburger_menu() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu.hamburgerComputerButton));
        hamburgerMenu.hamburgerComputerButton.click();

    }
    @Then("the user clicks notebook on the menu")
    public void the_user_choose_computer_on_the_menu() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu.notebookButton));
        hamburgerMenu.notebookButton.click();
    }
    @Then("the user verifies that on the notebookpage")
    public void the_user_verifies_that_on_the_notebookpage() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dizüstü Bilgisayarlar"));
    }

    @Then("the user clicks windows11 operating system on the left side")
    public void the_user_clicks_operating_system_on_the_left_side() {
    notebookPage.windows11Button.click();
    }
    @Then("the user verifies that correct filtering")
    public void the_user_verifies_that_correct_filtering() {
     notebookPage.allWin11ProductVerification();
    }


    @Then("the user clicks sorting drop down menu")
    public void the_user_clicks_sorting_drop_down_menu() {
    notebookPage.sortingDropDownMenu.click();
    }
    @Then("the user clicks low to high price in the dropdown menu")
    public void the_user_clicks_low_to_high_price_in_the_dropdown_menu() {
    notebookPage.lowToHighPrice.click();
    }
    @Then("the user verifes that all products sorted low to high")
    public void the_user_verifes_that_all_products_sorted_low_to_high() {
      notebookPage.sortingLowToHighVerification();
    }

    @Then("the user clicks high to low price in the dropdown menu")
    public void theUserClicksHightToLowPriceInTheDropdownMenu() {
       notebookPage.highToLowPrice.click();
    }

    @Then("the user verifes that all products sorted high to low")
    public void theUserVerifesThatAllProductsSortedHighToLow() {
        notebookPage.sortingHighToLowVerification();
    }

    @Then("the user clicks the free delivery filter")
    public void the_user_clicks_delivery_fee_check_box() {
        notebookPage.freeDeliveryCheckBox.click();
    }

    @Then("the user clicks each product and verifies that all products have free delivery")
    public void the_user_clicks_all_products_and_verifes_all_all_products_are_delivery_fee() {
        notebookPage.allProductFreeDeliveryw11();
    }

}
