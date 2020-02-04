
@sendMessageFeature
Feature: Test Send message page

  Scenario: Send a message
    Given I go Inbox Page
    When I click button 'Write message'
    When I input emails
    When I input text
    When I click 'Send message'
    Then I see 'Email send'