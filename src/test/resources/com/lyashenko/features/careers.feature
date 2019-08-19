Feature: Careers page test

Scenario: As a user, I would like to apply for a given position

    Given I enter 'https://www.worldremit.com/en/careers'
    When I go to open position form
    And I select a department 'Engineering & IT'
    And I select an office as 'Kraków'
    And I find a position for 'QA'
    And I open 'QA' position
    And I fill in an application form without a resume
    And I click on apply now
    Then Validation error 'Please attach a resume.' is displayed



    @ignore
Scenario: As a user, I would like to apply for a given position with CV and cover letter

    Given I enter 'https://www.worldremit.com/en/careers'
    When I go to open position form
    And I select a department 'Commercial'
    And I select an office as 'London'
    And I find a position for 'Data scientist'
    And I open 'Data scientist' position
    And I fill in all input fields in application form
    And I attach CV
    And I attach cover letter
    And I click on apply now
    Then Confirmation message is displayed


     @ignore
Scenario: As a user, I would like to see warning message for incorrectly filled fields in application form

    Given I enter 'https://www.worldremit.com/en/careers'
    When I go to open position form
    And I select a department 'Customer Service'
    And I select an office as 'London'
    And I find a position for 'Head'
    And I open 'Head' position
    And I click on apply now
    Then Validation error for each mandatory fields are displayed