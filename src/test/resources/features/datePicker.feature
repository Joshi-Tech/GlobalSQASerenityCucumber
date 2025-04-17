Feature: Date Picker Navigation


  Scenario: Navigate to Date Picker Page
    Given I go the home page
    When I click Date picker link within Tester's Hub
    Then I'll be in DatePicker page

  Scenario: Navigate to Alert page
    Given I go the home page
    When I click Alert link within Tester's Hub
    Then I'll be in Alert page

  Scenario: User can select correct date
    Given User is on DatePicker page
    When they select month "April" year "2026"
    And they select date "15"
    Then they will have date as "04/15/2026"
