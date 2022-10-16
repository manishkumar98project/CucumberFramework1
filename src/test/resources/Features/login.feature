Feature: feature to test login functionality

  @login
  Scenario Outline: Check login is sucessfull with valid credentials
    Given user is on login page
    When user enter <username> and <password> and <type>
    Then user is navigated to home page

    Examples: 
      | username      | password | type    |
      | mohit@        | pa10222  | valid   |
      | rio@gmail.com | pass123  | invalid |
      | rio@g.com     | pass123  | invalid |
