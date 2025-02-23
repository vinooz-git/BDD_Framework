@AhnRegression
Feature: Upload Thumbanil images for the product

  Background: Navigate to Login page for Admin
    Given User navigate to Login Page for Admin
    Then user logs in CRM
    Then user is redirected to the Anh Dashboard page

  @regression @uploadImage
  Scenario Outline: Login to admin user and upload the thumbnail images
    Given User navigate to Menu "<Menu>"
    Then User upload file "<filePath>"

    Examples:
      | Menu          | filePath                                                                            |
      | Uploaded Files| C:\Users\pvino\IdeaProjects\BDD_Framework\src\test\resources\TestData\download.jpeg |