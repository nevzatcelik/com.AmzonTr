@feature_login
Feature: User Login
  Background: User navigates to login page
    Given the user is on the "url" homepage
    When  the user navigates to the login page
  @priority @smoke @positive
  Scenario: Successful login with valid credentials

    And   the user enters "validEmail" email login credentials
    And   the user enters "validPassword" password login credentials
    Then  the user verifies that logged in by checking their name "validName"
    And   close the browser
  @priority @regression @negative
  Scenario: Unsuccessful login with invalid email credentials

    And   the user enters invalid email login credentials
    And   the user clicks the continue button
    Then  the user should see an error message indicating invalid credentials
    And   close the browser
  @regression @negative
  Scenario: Unsuccessful login with valid email invalid password credentials

     And  the user enters "validEmail" email login credentials
     And  the user enters "invalidPassword" password login credentials
     Then the user veifies that the password error message visible
     And  close the browser
