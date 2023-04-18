Feature: Customer CRUD Operations
  the list of customers of the system should is continuously changing, so there should be
  the option to perform CRUD operations on the customers list.

  Background: User reached the Edit Customer Tab
    Given main screen is opened
    And customers panel is opened
    And edit customer tab is opened

  Scenario: Adding Customer Successfully
    Given I enter a customer name, phone, address
    And the name is not empty
    And I click add customer button
    Then a new customer is added to the list

  Scenario: Updating Customer Successfully
    Given I select a customer from the list
    And I enter a different customer information
    And I click update customer button
    Then the selected customer is updated

  Scenario: Deleting Customer Successfully
    Given I select a customer from the list
    And I click delete customer button
    Then the selected customer is deleted

  Scenario: Searching Customer Successfully
    Given I enter a customer name, phone, address
    And I click search customer button
    Then the selected customer is found

