package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HamburgerMenu {

    public HamburgerMenu(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[@data-ref-tag=\"nav_em_1_1_1_9\"]")
    public WebElement hamburgerComputerButton;

    @FindBy(xpath = "(//a[@href=\"/gp/browse.html?node=12601898031&ref_=nav_em_co_laptop_0_2_5_2\"])[2]")
    public WebElement notebookButton;
}
