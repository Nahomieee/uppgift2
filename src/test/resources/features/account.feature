Feature: Create an account

  Scenario:
    Given I am on the right page
    When I put all the login info
    And Click the right boxes
    Then I will get to the confirmation page

  Scenario Outline:
    Given I am on the right page
    When I put all the login info
      | DateOfBirth | Forename    | Surname    | Email   |
      | <dob>       | <firstName> | <LastName> | <Email> |
    And Click the right boxes
    Then I will get to the confirmation page


    Examples:
      | dob        | firstName | LastName | Email                |
      | 14/13/2002 | Nahom     | Tesfay   | OfficeNT.3@gmail.com |
      | 14/04/2002 | .         | Tesfay   | OfficeNT.3@gmail.com |
      | 14/04/2002 | Nahom     | ?        | OfficeNT.3@gmail.com |