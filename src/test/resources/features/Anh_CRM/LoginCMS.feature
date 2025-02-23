@AhnRegression
Feature: Login Test CMS

  Background: Navigate to Login page for Admin
    Given User navigate to Login Page for Admin

  @regression @loginAnhCMS
  Scenario Outline: Login success
    When user enter email "<UserName>" password "<Password>"
    And click Login button
    Then user is redirected to the Anh Dashboard page
    Examples:
      | UserName          | Password |
      | admin@example.com | 123456   |

  @Testing @InvalidCreds
  Scenario Outline: Users log in with invalid email or invalid password credentials
    When user enter email "<UserName>" password "<Password>"
    And click Login button
    Then User verifies error message

    @SalesManager
    Examples: SalesManager's username and password
      | UserName              | Password |
      | adminTest@example.com | 123456   |

  @Testing @FailureCase
  Scenario Outline: Users log in with invalid email or invalid password credentials
    When user enter email "<UserName>" password "<Password>"
    And click Login button
    Then user is redirected to the Anh Dashboard page
    Examples:
      | UserName          | Password |
      | admin@exampl.com  | 1234567  |