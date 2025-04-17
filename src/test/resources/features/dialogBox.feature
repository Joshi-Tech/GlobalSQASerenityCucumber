Feature: Drop box attributes

  Scenario: user details can be seen
    Given user goes to the Dialog Box
    Then  they can see user name "John Doe"

  Scenario: create a new user
    Given user is on dialog box page
    When they click create user button
    And they provide name "Ram Singh", email "ram.singh@test.com" and password "test123"
    Then  they can see user name "Ram Singh" in the existing users list

  Scenario: capture message of confirmation box
    Given user is on dialog box page
    When they click on "Confirmation Box" tab
    Then they can see for "Confirmation Box" message "These items will be permanently deleted and cannot be recovered. Are you sure?"

  Scenario: capture message of message box
    Given user is on dialog box page
    When they click on "Message Box" tab
    Then they can see for "Message Box" message "Your files have downloaded successfully into the My Downloads folder."
