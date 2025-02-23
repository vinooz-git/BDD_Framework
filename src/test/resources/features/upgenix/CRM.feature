@UI
@Login @Sanity @Regression @CRMFeature
Feature: Pipeline operations in CRM feature

  Scenario Outline: Create a Pipeline in CRM
    Given Setup the Testing Environment
    When User enters "<username>" and password "<password>"
    And User clicks login button
    Then user is redirected to the Dashboard page
    Then user clicks "CRM" Menu
    Then user enter value "<OpportunityTitle>" for field "OpportunityTitle"
    Then user enter value "<Customer>" for field "Customer"
    Then user enter value "<ExpectedRevenue>" for field "ExpectedRevenue"
    Then user enter value "<ExpectedRevenue>" for field "ExpectedRevenue"
    Then user enter value "<Priority>" for field "Priority"

    Examples:
      | username                | password     | OpportunityTitle | Customer  | ExpectedRevenue | Priority     |
      | salesmanager7@info.com  | salesmanager | BDD-Selenium     | VK Groups | 22              | PriorityHigh |