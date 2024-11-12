@calculate
Feature:Home loan Interest Calculator

@financeCalculator
  Scenario Outline: check whether calculator Button is working
    Given the user is on homepage
    When user enter some required data loan amount"<loanAmount>"
    And user enter valid downPayment in % "<downPayment>"
    And user enter valid loan term"<loanTerm>"
    And user enter valid interest rate in %"<interestRate>"
    And click on calculate button
    Then calculated result should be shown
    Examples:
      | loanAmount | downPayment | interestRate | loanTerm |
      | 40000      | 15          | 8            | 9        |
      | 86000      | 26          | 7.30         | 17       |
      | 90000      | 22          | 5.5          | 29       |

  @Invalid
  Scenario Outline: Verify calculator button with invalid inputs
    Given the user is on homepage
    When user enter some required data loan amount"<loanAmount>"
    And user enter valid downPayment in % "<downPayment>"
    And user enter valid loan term"<loanTerm>"
    And user enter valid interest rate in %"<interestRate>"
    And click on calculate button
    Then error message should be display "<errorMessage>"
    Examples:
      | loanAmount | downPayment | interestRate | loanTerm | errorMessage                               |
      | -1000000   | 15          | 8            | 9        | Please provide a positive home price value |
      |            |             | 7.30         |          | Please provide a positive home price value |
      | -90000     | -22         | -5.5         | -14      | Please provide a positive home price value |
      |            |             |              |          | Please provide a positive home price value |
@Links
   Scenario: verify different links are working on homepage
      Given the user is on homepage
      When user click on financial link financial calculator page should displayed
      Then user click on fitness link fitness calculator page should displayed
      And user click on math link math calculator page should displayed
      And user click on others calculator link page should open

@fitness
Scenario Outline: verify fitness health calculator is working
  Given the user is on homepage
  Then user click on fitness link fitness calculator page should displayed
  And user click on BMI link calculator
  When user enter valid age"<age>"
  And user enter valid height "<height>"
  And user enter valid weight "<weight>"
  Then calculated BMI result graph should displayed
Examples:
  | age | height | weight |
  | 23  | 172    | 50     |
  | 22  | 175    | 60     |
  | 28  | 178    | 80     |

  @bodyFatCalculator
  Scenario Outline: verify fitness health calculator is working
    Given the user is on homepage
    Then user click on fitness link fitness calculator page should displayed
    And user click on body fat percentage calculator
    Then user enter require valid age data "<age>"
    And user enter height (cm) "<height>"
    And user enter weight(kg) "<weight>"
    Then user enter waistSize(cm) "<waist>"
    And user enter neckSize(cm) "<neck>"
    Then click on calculate
    And verify that result is displayed

    Examples:
      | age | height | weight | neck | waist |
      | 25  | 170    | 50     | 43   | 190   |
      | 30  | 180    | 60     | 45   | 180   |
      | 24  | 175    | 70     | 40   | 200   |
      | 28  | 165    | 65     | 50   | 210   |
      | 30  | 170    | 70     | 60   | 200   |


    @temperatureCalculator
    Scenario Outline: verify that heat index temperature calculator is working
      Given the user is on homepage
      When user click on financial link financial calculator page should displayed
      Then user click on fitness link fitness calculator page should displayed
      And user click on math link math calculator page should displayed
      And user click on others calculator link page should open
      Then user click on temperature calculator
      And enter air temperature "<temperature>"
      And enter humidity "<humidity>"
      Examples:
        | temperature | humidity |
        | 30          | 80       |
        | 35          | 90       |
        | 20          | 55       |
        | 20          | 29       |
    @calculatorGPA
    Scenario Outline: verify that GPA calculator is working
      And user click on others calculator link page should open
      When the user clicks on marks Grade  calculator button
      Then user enters valid subjects "<subjects>">
      And user enters valid marks credits "<marks>"
      And user enters valid Grade "<grade>"
      Then user click on calculate marks button
      And verify that calculated marks result is displayed
      Examples:
        | subjects | marks | grade |
        | English  | 9     | A     |
        | Hindi    | 8     | B     |
        | Math     | 7     | B     |
        | Science  | 5     | C     |
        | SST      | 8     | A     |


