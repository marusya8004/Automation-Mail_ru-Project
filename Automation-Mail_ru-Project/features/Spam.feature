
@spamFeature
Feature: Test move this letter to spam and return from spam

  Scenario: Move this letter to spam
    Given I am on inbox page
    When I choose this letter
    Then I click button 'to spam'
    Then I am in spam pocket
    Then I click this letter
    Then I click button 'not spam'
    And I see message 'in your mail no spam'
