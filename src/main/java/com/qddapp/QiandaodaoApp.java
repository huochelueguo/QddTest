package com.qddapp;

import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class QiandaodaoApp {
    public static String DEVICENAME = "Android Emulator";
    private static WebElement SerchText;

    public static void main( String[] args ) throws InterruptedException, MalformedURLException {
        DesiredCapabilities  desired= new DesiredCapabilities();
        /*虚拟机
        desired.setCapability("deviceName",DEVICENAME);
        desired.setCapability("automationName","Appium");
        desired.setCapability("platformName", "Android");
        desired.setCapability("platformVersion", "4.4.2");
        desired.setCapability("appPackage", "com.daodao.qiandaodao");
        desired.setCapability("appActivity", ".home.MainActivity");
        desired.setCapability("appWaitActivity",".home.MainActivity");
        desired.setCapability("sessionOverride",true);
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session*/

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
        try {
            WebElement elementByXPath = driver.findElementByXPath("//android.view.View[contains(@index,2)]");
            if (elementByXPath != null)
            {
                driver.findElementByClassName("android.widget.ImageView").click();
           // driver.findElementById("com.daodao.qiandaodao:id/fl_messages").click();
            Thread.sleep(2000);
            driver.findElementById("com.daodao.qiandaodao:id/menu_text").click();
            driver.findElementById("com.daodao.qiandaodao:id/et_login_phone").sendKeys("18500616906");
            driver.findElementById("com.daodao.qiandaodao:id/et_login_password").sendKeys("123456");

            /* driver.hideKeyboard();*/
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);/*退出键盘，使系统能找到登录按钮*/
            driver.findElementById("com.daodao.qiandaodao:id/btn_login").click();
            driver.closeApp();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
