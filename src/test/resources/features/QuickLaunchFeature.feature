@smoke1
Feature: OrangeHRM Button Click and URL Validation

  Scenario Outline: User clicks on buttons and verifies their corresponding URLs
    Given the user is on the login page1
    When the user enters valid1 username "admin" and password "admin123"
    Then the user should be redirected to the homepage1
    And the user clicks on the "<buttonName>" button
    And the user verifies the URL for "<buttonName>" button is "<expectedUrl>"

    Examples:
      | buttonName  | expectedUrl                                                                                         |
      | Admin       | https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers                       |
      | PIM         | https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList                        |
      | Leave       | https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList                         |
      | Time        | https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet                  |
      | Recruitment | https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates                  |
      | My Info     | https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7         |
      | Performance | https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview |
      | Dashboard   | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index                             |
      | Directory   | https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory                     |
      | Maintenance | https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee                   |
      | Claim       | https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim                       |
      | Buzz        | https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz                               |
      |             |                                                                                                     |
