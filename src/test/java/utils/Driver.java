package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        String browser =ConfigReader.getProperty("browser");


        if (driver == null){

            switch (browser){
                case "chrome":
                    driver=new ChromeDriver();

                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;
                case  "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        if (driver != null){
            driver = null;
        }

    }
}
