Feature: TicketBooking

  Scenario: Ticket Booking process via Paytm
    Given user launch browser and enter url
    Given the user is on the Paytm flight booking page
    When the user selects a departure city
    And the user selects a destination city
    And the user selects the departure date
    And the user selects adult traveler
    And the user clicks on the search flight button
    And user clicks on flight details button
    Then user click on proceed button
    And user switch to next window
    Then user scroll to phoneNumber
    Then user enter their Mobile no
    And user clicks on proceeds to pay
    And enter login details
    And user checks