Feature: Add employee for HRMs portal

  Background:
    Then users enters valid userName and Password
    And user enters log in button
    Then user can see dashboard
    When user clicks on PIM button
    And user clicks on AddEmployee

  @IdGenerator
  Scenario:automatically generate employee id
    When user enters employee firstName, middleName and lastName
    Then employee id is generated automatically
    When user clicks on SaveBt
    Then employee is added successfully


  @UsingAndId
  Scenario:add employee Id as well
    When user enters employee firstName, middleName and lastName
    And user clears Id field and enters new id
    When user clicks on SaveBt
    Then employee is added successfully

  @LastnameError
  Scenario: attempt to add employee only with firstName
    When user enters employee firstName
    When user clicks on SaveBt
    Then lastName error is displayed

  @FirstnameError
  Scenario: attempt to add employee only with lastname
    When user enters employee lastname
    When user clicks on SaveBt
    Then the firstname error is displayed

  @EmptyFields
  Scenario: attempt to add employee with empty fields
    When user clicks on SaveBt
    Then lastName error is displayed
    Then the firstname error is displayed

  @ExistingId
  Scenario: attempt to add employee with existing Id
    When user enters employee firstName, middleName and lastName
    And user enters existing IdNumber
    When user clicks on SaveBt
    Then existing id error is displayed