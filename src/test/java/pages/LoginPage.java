package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement signInButton;
    @FindBy(xpath = "//*[@class='a-unordered-list a-nostyle a-vertical a-spacing-none']")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@class='a-list-item']")
    public WebElement errorPasswordMessage;
}
