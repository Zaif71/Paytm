@valid
Feature: Valid login
  As a user, I want to successfully log in to the system when I provide correct credentials,
  so that I can access the homepage.

  Scenario Outline: Successful login with valid credentials

    Given the user is on the login page1.
    When  user enters valid username "Admin" and password "admin123"
    Then  user should be redirected to the homepage
    And read the data from excel
    And user click on add user button User should be created
    Then user add new employee after
    And user clicks on multiple "<button>"
    Examples:
      | button      |
      | Admin       |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |







