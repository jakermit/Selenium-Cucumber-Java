Feature: Validating News Articles on The Guardian to prevent fake news. Confirm that news from The Guardian site is valid

  Scenario: Confirm the validity of the first news article in Google - when we pass entire title as it is
    Given I am on The Guardian website's news section
    And I retrieve the title of the first news article
    When I search Google for articles with the same title and count number of search results
    Then I consider the article valid if there are 2 or more matching results

  Scenario: Confirm the validity of the first news article in Bing - when we pass entire title as it is
    Given I am on The Guardian website's news section
    And I retrieve the title of the first news article
    When I search Bing for articles with the same title and count number of search results
    Then I consider the article valid if there are 2 or more matching results

  Scenario: Confirm the validity of the first news article in Google - when we pass entire title in quotes
    Given I am on The Guardian website's news section
    And I retrieve the title of the first news article
    And I add quotes to the title
    When I search Google for articles with the same title and count number of search results
    Then I consider the article valid if there are 2 or more matching results

  Scenario: Confirm the validity of the first news article in Google - when we pass entire title in quotes and turn on exact results
    Given I am on The Guardian website's news section
    And I retrieve the title of the first news article
    And I add quotes to the title
    When I search Google for articles with the same title and count number of search results
    And  I turn on exact results on google and re-count number of search results
    Then I consider the article valid if there are 2 or more matching results

  Scenario: Confirm the validity of the first news article in Bing - when we pass entire title in quotes
    Given I am on The Guardian website's news section
    And I retrieve the title of the first news article
    And I add quotes to the title
    When I search Bing for articles with the same title and count number of search results
    Then I consider the article valid if there are 200 or more matching results