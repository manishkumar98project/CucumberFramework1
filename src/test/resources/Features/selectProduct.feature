Feature: feature to test selection of product functionality

  Background: Check login is sucessfull with valid credentials
    Given user is on login page
    And user enter rio@gmail.com and pass123 and valid
    Then user is navigated to home page

  @tag3
  Scenario Outline: Test for Selection of product
    Given navigated to home page
    Then click on this <categories>
    And select product you like Eg:<product>
    And print product detail
    Then verify it is selected product
    Then click on add to cart
    And check if the product is added to cart

    Examples: 
      | categories | product      |
      | Mobile     | Nexus 6      |
      | Laptops    | Sony vaio i5 |
