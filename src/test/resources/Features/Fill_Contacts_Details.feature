Feature: For filling Contacts Data

  Background: Check login is sucessfull with valid credentials
    Given user is on login page
    And user enter rio@gmail.com and pass123 and valid
    Then user is navigated to home page

  @tag3
  Scenario Outline: Testing Contacts Box
    Given navigated to home page
    Then click at Contacts to fill details
    And fill details Contact-email <email>
    And fill ContactName <name>
    And fill any Message <message>
    Then click send message

    @data1
    Examples: 
      | email      | name  | message                       |
      | rgmail.com | name1 | Good Website for practice     |
      | wgmail.com | name3 | Add new Features for practice |

    @data2
    Examples: 
      | email      | name  | message                   |
      | rgmail.com | name1 | Good Website for practice |
