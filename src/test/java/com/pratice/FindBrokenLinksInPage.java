package com.pratice;


import com.vk.qa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindBrokenLinksInPage {
    private static WebDriver driver;
     public FindBrokenLinksInPage()
     {
         driver = Driver.getDriver();
     }

     public static void brokenLinksInPage() throws IOException {
         // URL, HttpURlConnection are from Java.Net Package
         driver.get("https://bstackdemo.com/");
         List<WebElement> linkLists = driver.findElements(By.tagName("a"));
         for(WebElement ele:linkLists)
         {
           String href = ele.getAttribute("href");
           URL url = new URL(href);
           HttpURLConnection con = (HttpURLConnection)url.openConnection(); // openConnection return URL Connection
           int response =  con.getResponseCode();                          // - but requires HttpURLConnection
           if(response == 200)
           {
               System.out.println("Success Status : "+response+" : Url:" +url);
           }
           else {
               System.out.println("Failure Status : "+response+" : Url:" +url);
           }
         }
     }


     public static void main(String[] args) throws IOException {
         FindBrokenLinksInPage broken = new FindBrokenLinksInPage();
         broken.brokenLinksInPage();
     }
}
