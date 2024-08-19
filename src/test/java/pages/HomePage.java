package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    Actions action=new Actions(Driver.getDriver());

    @FindBy(xpath = "//*[@id='sp-cc-rejectall-link']")

    public WebElement cookie;

    @FindBy(xpath = "//a[@data-csa-c-slot-id=\"nav-link-accountList\"]")
    private WebElement accountAndList;

    @FindBy(xpath = "//*[text()='Üye olun.']")
    private WebElement becomeAMember;

    @FindBy(xpath = "(//span[text()='Giriş yap'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement userNameSection;
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    public WebElement hamburgerMenu;




    public void navigateRegistirationPage(){
      if (cookie.isDisplayed()) {
          cookie.click();
          action.moveToElement(accountAndList).perform();
          becomeAMember.click();
      }else {
          action.moveToElement(accountAndList).perform();
          becomeAMember.click();
      }

    } public void navigateLoginPage(){
        if (cookie.isDisplayed()) {
            cookie.click();
            action.moveToElement(accountAndList).perform();
            loginButton.click();
        }else {
            action.moveToElement(accountAndList).perform();
            loginButton.click();
        }

    }
    }





