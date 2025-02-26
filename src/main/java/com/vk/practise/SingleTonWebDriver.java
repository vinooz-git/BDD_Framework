package com.vk.practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingleTonWebDriver {

    private static SingleTonWebDriver instance;
    private static WebDriver driver;

    private SingleTonWebDriver()
    {

    }

    public SingleTonWebDriver getInstance()
    {
        if(instance==null)
        {
            instance = new SingleTonWebDriver();
        }
        return instance;
    }

    public WebDriver setDriver()
    {
        driver = new ChromeDriver();
        new FirefoxDriver();
        return driver;
    }
}

/**
 *  Calling this method, getInstance().setDriver();
 */