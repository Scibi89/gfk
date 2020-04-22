Feature: NYTimes Most Popular


  Scenario: Coronavirus should be popular topic in this days

    Then Coronavirus is popular topic


  Scenario: User with wrong API key should be unauthenticated
    When Client with not authenticated api key sends request

    Then System reject request
