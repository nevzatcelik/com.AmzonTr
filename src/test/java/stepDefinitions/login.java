package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class login {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    Faker faker=new Faker();

    @When("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
     homePage.navigateLoginPage();
    }
    @When("the user enters {string} email login credentials")
    public void the_user_enters_valid_login_credentials(String email) {
     loginPage.emailBox.sendKeys(ConfigReader.getProperty(email));
     loginPage.continueButton.click();
    }
    @When("the user enters {string} password login credentials")
    public void the_user_enters_valid_login_password_credentials(String email) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty(email));
        loginPage.signInButton.click();
    }
    @Then("the user verifies that logged in by checking their name {string}")
    public void the_user_verifies_that_logged_in_by_checking_their(String userName) {
        Assert.assertEquals(homePage.userNameSection.getText(),ConfigReader.getProperty(userName));
    }
    @When("the user enters invalid email login credentials")
    public void the_user_enters_invalid_email_login_credentials() {
       loginPage.emailBox.sendKeys(faker.internet().emailAddress());
    }
    @When("the user submits the login form")
    public void the_user_submits_the_login_form() {
      loginPage.continueButton.click();
    }
    @When("the user clicks the continue button")
    public void the_user_clicks_the_continue_button() {
        loginPage.continueButton.click();
    }
    @Then("the user should see an error message indicating invalid credentials")
    public void the_user_should_see_an_error_message_indicating_invalid_credentials() {
      Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
    @When("the user veifies that the password error message visible")
    public void the_user_veifies_that_the_passwor_error_message_visible() {
       Assert.assertTrue(loginPage.errorPasswordMessage.isDisplayed());
    }


}
