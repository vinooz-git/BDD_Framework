package com.vk.qa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Driver {

    private Driver(){

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    /*
    Create a re-usable utility method which will return same driver instance when we call it
    */
    public static WebDriver getDriver(){
        if(driverPool.get() == null){
            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
            */

            //String browserType = ConfigurationReader.getProperty("browser");
            String browserType = System.getProperty("BrowserType");
            System.out.println(browserType);
                switch(browserType){
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }
        }
        return driverPool.get();
    }

    /*
       This method will make sure our driver value is always null after using quit() method
    */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
