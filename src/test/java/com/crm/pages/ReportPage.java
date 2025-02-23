package com.crm.pages;

import com.vk.qa.utilities.AllureListeners;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.GeneralWrappers;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;


public class ReportPage {
    private static WebDriver driver;
    public ReportPage()
    {
        driver = Driver.getDriver();
    }

    //Login

     By MenuLink      =  By.xpath("//span[text()='menuReplace']");
     By SelectDropDwn = By.id("demo-ease");
     By CategoryDropDown = By.xpath("//button[@data-id='demo-ease']");
     By Header = By.xpath("//tr[@class='footable-header']/th");
     By TableObj = By.xpath("//table/tbody");
     By FileterBttn = By.xpath("//button[text()='Filter']");
    GeneralWrappers wrappers = new GeneralWrappers();
    AllureListeners allureListeners = new AllureListeners();
    public void clicksMenu(String menu)
    {
        driver.findElement(By.xpath("//span[contains(text(),'" + menu + "')]")).click();
        wrappers.waitForPageLoaded();
    }

    public void filterByCategory(String Category)
    {
        driver.findElement(CategoryDropDown).click();
        WebElement element = driver.findElement(SelectDropDwn);
        Select select = new Select(element);
        select.selectByVisibleText(Category);
        wrappers.waitForPageLoaded();
        driver.findElement(FileterBttn).click();
    }

    public HashMap<String,Integer> getTheListOfProducts(String Header1, String Header2)
    {
        HashMap<String,Integer> productList = new HashMap<>();

        wrappers.waitForPageLoaded();
        wrappers.waitForVisibilityOfElement(TableObj);
        WebElement Table = driver.findElement(TableObj);
        allureListeners.addElementScreenshotinReport(Table);
        List<WebElement> allRows = Table.findElements(By.xpath("//tr"));
        //productList.put(Header1,Header2);
        int header1Index =  getHeaderIndex(Header1);
        int header2Index =  getHeaderIndex(Header2);

        for(int i=1; i<allRows.size(); i++)
        {
         List<WebElement> allcolumns= driver.findElements(By.xpath("(//table/tbody/tr)["+i+"]/td"));
         productList.put(allcolumns.get(header1Index).getText(),Integer.parseInt(allcolumns.get(header2Index).getText()));
        }

        return productList;
    }

    public List<WebElement> getHeaders()
    {
        List<WebElement> headerList = new LinkedList<>();
        headerList = driver.findElements(Header);
        return headerList;
    }
    public Integer getHeaderIndex(String HeaderName)
    {
        int index = 0;
        List<WebElement> headers = getHeaders();
        for(int i=0; i<headers.size();i++)
        {
            if(headers.get(i).getText().equals(HeaderName))
            {
                index = i;
            }
        }
        return index;
    }

    public static String getTheHighestSoldProduct(HashMap<String,Integer> products)
    {
        String HighestSaleProduct;
        LinkedHashMap<String,Integer> productList = products.entrySet()
                                             .stream()
                                             .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                                             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));


    productList.forEach((x,y)-> System.out.println(x + y));

    HighestSaleProduct = productList.entrySet().stream().findFirst().get().getKey();
    int HighestSaleQty = productList.entrySet().stream().findFirst().get().getValue();
    System.out.println(HighestSaleProduct);
    Allure.step("Highest Sold item - "+HighestSaleProduct+" and the sale Qty is : "+HighestSaleQty);
    return HighestSaleProduct;

    }
}


