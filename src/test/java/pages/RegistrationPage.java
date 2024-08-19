package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class RegistrationPage {
    Faker faker=new Faker();
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement nameAndSurnameBox;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailBox;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement passwordBox2;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement createAccButton;
    @FindBy(xpath = "//div[@id='auth-warning-message-box']")
    public WebElement warningMessage;

    @FindBy(xpath = "(//div[@class='a-alert-content'])[4]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "(//div[@class='a-alert-content'])[12]")
    public WebElement misMatchedPasswordMessage;

    public void registirationUserInfo(String email){
        nameAndSurnameBox.sendKeys(faker.name().fullName());
        emailBox.sendKeys(ConfigReader.getProperty(email));
        String password=faker.internet().password();
        passwordBox.sendKeys(password);
        passwordBox2.sendKeys(password);
    }

    public void misMatchedPasswordVerify (){
        nameAndSurnameBox.sendKeys(faker.name().fullName());
        emailBox.sendKeys(faker.internet().emailAddress());
        passwordBox.sendKeys(faker.internet().password());
        passwordBox2.sendKeys(faker.internet().password());
        createAccButton.click();
    }

    public void registiration(){
        String email = "testuser" + System.currentTimeMillis() + "@nevzatteam.testinator.com";
        nameAndSurnameBox.sendKeys(faker.name().fullName());
        emailBox.sendKeys(email);
        String samePassword=faker.internet().password();
        passwordBox.sendKeys(samePassword);
        passwordBox2.sendKeys(samePassword);
        createAccButton.click();
    }
}
