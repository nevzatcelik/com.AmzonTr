package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.Driver;

public class register {
    HomePage homePage =new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();
    Faker faker=new Faker();


    @Given("the user is on the {string} homepage")
    public void the_user_is_on_the_amazon_homepage(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @When("the user navigates to the registration page")
    public void the_user_navigates_to_the_registration_page() {
       homePage.navigateRegistirationPage();
    }
    @When("the user enters valid registration details")
    public void the_user_enters_valid_registration_details() throws InterruptedException {


    }
    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
     registrationPage.createAccButton.click();
    }
    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {

    }
    @Then("the user should see a confirmation message")
    public void the_user_should_see_a_confirmation_message() {

    }
    @When("the user enters an {string} that is already registered")
    public void the_user_enters_an_email_that_is_already_registered(String email) {
        registrationPage.registirationUserInfo(email);
    }
    @Then("the user should see an error message indicating the email is already in use")
    public void the_user_should_see_an_error_message_indicating_the_email_is_already_in_use() {
        Assert.assertTrue(registrationPage.warningMessage.isDisplayed());
    }

    @When("the user enters an {string} email format")
    public void the_user_enters_an_invalid_email_format(String invalidEmail) {
      registrationPage.registirationUserInfo(invalidEmail);
    }
    @Then("the user should see an error message indicating the email format is invalid")
    public void the_user_should_see_an_error_message_indicating_the_email_format_is_invalid() {
      Assert.assertTrue(registrationPage.invalidEmailMessage.isDisplayed());
    }

    @Then("close the browser")
    public void close_the_browser() {
     Driver.quitDriver();
    }

    @When("the user enters mismatched passwords")
    public void the_user_enters_mismatched_passwords() {
        registrationPage.misMatchedPasswordVerify();
    }
    @Then("the user should see an error message indicating the passwords do not match")
    public void the_user_should_see_an_error_message_indicating_the_passwords_do_not_match() {
        registrationPage.misMatchedPasswordMessage.click();
    }


}
