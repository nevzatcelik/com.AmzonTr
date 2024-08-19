@feature_register
Feature: User Registration
         As a user I want to create a new account on the Amazon website
  Background: user opens the url and navigate the registiration page
    Given the user is on the "url" homepage
    When  the user navigates to the registration page
  ## 2FA VERIFICATION
  Scenario: Successful User Registration
    And   the user enters valid registration details
    And   the user submits the registration form
    Then  the user should be successfully registered
    And   the user should see a confirmation message
    And   close the browser
  @priority @regression @negative
  Scenario: Registration with Already Registered Email

    And   the user enters an "registeredEmail" that is already registered
    And   the user submits the registration form
    And   the user should see an error message indicating the email is already in use
    And   close the browser
  @priority @regression @negative
  Scenario Outline: Registration with Invalid Email Format
    And   the user enters an "<invalidEmail>" email format
    And   the user submits the registration form
    Then  the user should see an error message indicating the email format is invalid
    And   close the browser
    Examples:
      |invalidEmail |
      |invalidMail1  |
      |invalidMail2  |
      |invalidMail3  |
      |invalidMail4  |
      |invalidMail5  |
  @regression @negative
  Scenario: Registration with Mismatched Passwords
    And   the user enters mismatched passwords
    And   the user submits the registration form
    Then  the user should see an error message indicating the passwords do not match
    And   close the browser
