package com.qddapp;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "DEVICENAME");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

       AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("9")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("=")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/digit9")).getText();
        System.out.println(result);

        driver.quit();
    }

}