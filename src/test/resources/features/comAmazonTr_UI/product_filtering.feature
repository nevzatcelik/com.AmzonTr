@product_filtering
Feature: As a User I want to filter computer on Amazon web site

    Background: User navigates to notebook page
    Given the user is on the "url" homepage
    And  the user navigates to all product hamburger menu on the left corner
    And  the user clicks computers on the hamburger menu
    And  the user clicks notebook on the menu
 @smoke
  Scenario: The user verifies that navigated to notebook page
    Then the user verifies that on the notebookpage
    And  close the browser
  @regression @positive
  Scenario: The user verifies that win11 os is filterable
    Then  the user clicks windows11 operating system on the left side
    Then  the user verifies that correct filtering
    And   close the browser
  @priority @regression @positive
  Scenario: The user verifies that win11 os is sorted low to high
    Then  the user clicks windows11 operating system on the left side
    Then the user clicks sorting drop down menu
    Then the user clicks low to high price in the dropdown menu
    Then the user verifes that all products sorted low to high
    And  close the browser
  @priority @regression @positive
  Scenario: The user verifies that win11 os is sorted high to low
    Then  the user clicks windows11 operating system on the left side
    Then the user clicks sorting drop down menu
    Then the user clicks high to low price in the dropdown menu
    Then the user verifes that all products sorted high to low
    And  close the browser
    @regression @positive
  Scenario: Scenario: The user verifies that Windows 11 OS products have free delivery
    Then  the user clicks windows11 operating system on the left side
    Then  the user clicks the free delivery filter
    Then  the user clicks each product and verifies that all products have free delivery
    And   close the browser