@AhnRegression
Feature: Sale Report validation

Background: Navigate to Login page for Admin
Given User navigate to Login Page for Admin
Then user logs in CRM
Then user is redirected to the Anh Dashboard page

@regression @SaleReport
Scenario Outline: Open the Product Sale report Menu and list down product by the category - <SubMenu> and get the highest sold product
 Given User navigate to Menu "<Menu>"
 Then User navigate to Menu "<SubMenu>"
 Then User filter the report for "<SortByCategory>"
 Then User navigate to all the result page and verify the sold Product
 Then User filtered out the highest sold product

Examples:
| Menu   | SubMenu               | SortByCategory |
| Reports| In House Product Sale | Cake           |