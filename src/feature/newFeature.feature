Feature: Proof of concept

  Scenario: Search iPhone in google and look for amazon link which sell iPhone for less than 800
    Given I am on Google website
    When I click on the search text box and type iPhone
    And I click google search button
    And I found amazon site that sell iPhone from the search results
    Then I navigate to the amazon site
    Then I find name and size of the largest model which is cost less than 800
