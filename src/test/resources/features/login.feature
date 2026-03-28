Feature: Login Test

  @loginTag
  Scenario: Open browser
    Given user launches browser
    When user opens application
    Then page title should be visible
    Then Take a screenshot of the "Google Page" page
    And user closes browser