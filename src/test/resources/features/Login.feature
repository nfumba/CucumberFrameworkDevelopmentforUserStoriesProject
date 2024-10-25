Feature: Login Validation for HRMs Portal

  Background:
    #Given user is able to access HRMS application
  @EmptyUsername @asa
  Scenario:attempts to log in with an empty username field
    #Given user is bale to access HRMS application
    Then user  only enters password
    And user enters log in button
    Then user can see error message"Username cannot be empty"

  @EmptyPassword @asa
  Scenario:attempts to log in with an empty password field
    Then user only enters username
    And user enters log in button
    Then user can see error message"Password is empty"

  @InvalidCredentials @asa
  Scenario:attempts to log in with invalid credentials
    Then user enters invalid username and password
    And user enters log in button
    Then user can see error message"Invalid credentials
    And username and password should be clear again
  @ClearVisible
  Scenario:Error message is visible, clear and placed near the input fields
    Then user enters invalid username and password
    And user enters log in button
    Then user clearly can see error message
    And it is placed near the respective input fields
  @Valid
  Scenario: attempts to log in with valid credentials
    Then users enters valid userName and Password
    And user enters log in button
    Then user can see dashboard
