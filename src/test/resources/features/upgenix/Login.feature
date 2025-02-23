@UI
@Login @Sanity @Regression
Feature: CRM app login feature

  Scenario Outline: Users log in with valid credentials
    Given Setup the Testing Environment
    When User enters "<username>" and password "<password>"
    And User clicks login button
    Then user is redirected to the Dashboard page
    Examples:
      | username                | password     |
      | salesmanager7@info.com  | salesmanager |
      | salesmanager8@info.com  | salesmanager |
      | salesmanager9@info.com  | salesmanager |
      | salesmanager10@info.com | salesmanager |
      | salesmanager11@info.com | salesmanager |
#      | posmanager5@info.com    | posmanager   |
#      | posmanager6@info.com    | posmanager   |
#      | posmanager7@info.com    | posmanager   |
#      | posmanager8@info.com    | posmanager   |
#      | posmanager9@info.com    | posmanager   |

  @Testing
  Scenario Outline: Users log in with invalid email or invalid password credentials
    Given Setup the Testing Environment
    When User enters "<username>" and password "<password>"
    And User clicks login button
    Then User verify error message

    @SalesManager
    Examples: SalesManager's username and password
      | username                | password     |
      | salesmanager6@info.com  | saLesManager |
      | salesm27aners@info.com  | salesmanager |
      | salesmanager8@info.com  | sale@g@0fz8r |
      | salesmanage28@info.com  | saleSM2na2er |
#      | salesmanager10@info.com | SaLeSMaNaGeR |
#      | posmanager5@info.com    | posmanager1  |
#      | posmanagerr6@info.com   | posmanager   |
#      | posmanger8@info.com     | posmager     |
#      | posmanager8@info.com    | po2sm232ger  |
#      | posmanager9@info.com    | posFkc@ma#$  |

 @HappyFlow
  Scenario Outline: Users log in with valid credentials
    Given Setup the Testing Environment
    When User enters "<username>" and password "<password>"
    And User clicks login button
    Then user is redirected to the Dashboard page
    Examples:
      | username                | password     |
      | salesmanager7@info.com  | salesmanager |