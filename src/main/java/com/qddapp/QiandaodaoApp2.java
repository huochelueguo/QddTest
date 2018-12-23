package com.qddapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class QiandaodaoApp2 {
    public static String DEVICENAME = "Android Emulator";
    private static WebElement SerchText;

    public static void main( String[] args ) throws InterruptedException, MalformedURLException {
        DesiredCapabilities  desired= new DesiredCapabilities();


        /*真机vivo+appium-desktop*/
        desired.setCapability("deviceName","2bdfc8b1");
        desired.setCapability("automationName","Appium");
        desired.setCapability("platformName","Android");
        desired.setCapability("platformVersion","7.1.1");
        desired.setCapability("appPackage","com.daodao.qiandaodao");
        desired.setCapability("appActivity", ".splash.activity.SplashActivity");/*主入口*/



        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desired);

        //测试从信箱进入登录环节

        Thread.sleep(5000);
       // driver.findElementById("com.daodao.qiandaodao:id/flash_button").click();
        WebElement elementById = driver.findElementById("com.daodao.qiandaodao:id/flash_button");
        System.out.println(elementById.isEnabled());


    }



}
