



  @invalidLogin

Feature: Invalid login attempts
  As a user, I want to see appropriate error messages when I attempt to log in with invalid credentials
  so that I can correct my input.

  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    Then an error message "<error_message>" should be displayed

    Examples:
      | username   | password  | error_message                                 |
      | wrongUser  | admin@123 | Invalid credentials                           |
      | Admin      | wrongPass | Invalid credentials                           |
      | wrongUser  | wrongPass | Invalid credentials                           |
      |            | admin@123 | Invalid credentials                           |
      | Admin      |           | Invalid credentials                           |
      |            |           | Username and password are required            |
      | lockedUser | validPass | Your account is locked due to failed attempts |
