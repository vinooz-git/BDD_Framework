package com.vk.qa.step_definitions.Anh;

import com.vk.qa.pages.Anh.LoginPage;
import com.vk.qa.pages.Anh.ReportPage;
import com.vk.qa.utilities.ProjectConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.TreeMap;

public class ReportSteps {

    ReportPage report = new ReportPage();
    ProjectConstants constants = new ProjectConstants();
    HashMap<String, Integer> ProductLists;
    @Given("User navigate to Menu {string}")
    public void user_navigate_to_menu_(String menu) {
        report.clicksMenu(menu);
    }

    @Then("User filter the report for {string}")
    public void user_filter_the_report_for(String category) {
        report.filterByCategory(category);
    }
    @Then("User navigate to all the result page and verify the sold Product")
    public void user_navigate_to_all_the_result_page_and_verify_the_sold_product() {
        ProductLists = report.getTheListOfProducts("Product Name","Num of Sale");
    }
    @Then("User filtered out the highest sold product")
    public void user_filter_sold_Product()
    {
       report.getTheHighestSoldProduct(ProductLists);
    }
}
