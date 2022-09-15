import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class ProjectTest {


    @Test
    void action(){
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.BUTTONSURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement dynamicBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")));

        dynamicBtn.click();

        WebElement doubleClickBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLECLICKBTN)));
        actions.doubleClick(doubleClickBtn).perform();

        WebElement contextClickBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CONTEXTCLICKBTN)));
        actions.contextClick(contextClickBtn).perform();

        //driver.quit();
    }

    @Test
    void alert() throws InterruptedException {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.ALERTURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.REGULARALERT))).click();
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.TIMEALERTBTN))).click();
//        wait.until(ExpectedConditions.alertIsPresent()).accept();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CONFIRMBTN))).click();
////        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PROMPTBTN))).click();
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys("Tom");

    }

    @Test
    void repeat(){
        WebDriver driver = Helper.setupDriver();
//        driver.get(Helper.TEXTFIELDURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        WebElement fullNameField =
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.FULLNAMEFIELD)));
//
//        fullNameField.sendKeys("Hello");
//        fullNameField.clear();
//        fullNameField.sendKeys(" World");

//        driver.get(Helper.BUTTONSURL);
//        Actions actions = new Actions(driver);
//        //WebElement doubleClickBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLECLICKBTN)));
//        actions.doubleClick(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLECLICKBTN)))).perform();
//        actions.contextClick(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CONTEXTCLICKBTN)))).perform();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.ONECLICKBTN))).click();

        driver.get(Helper.ALERTURL);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.REGULARALERT))).click();
//        driver.switchTo().alert().accept();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.TIMEALERTBTN))).click();
//        wait.until(ExpectedConditions.alertIsPresent()).accept();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CONFIRMBTN))).click();
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PROMPTBTN))).click();
        driver.switchTo().alert().sendKeys("Tom");
        driver.switchTo().alert().accept();


    }

    @Test
    void assertExample(){
        WebDriver driver = Helper.setupDriver();
        driver.get(Wiki.WIKICAT);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Wiki.SEARCHFIELDID))).sendKeys("Duck");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Wiki.SEARCHBTN))).click();
//        if (driver.getCurrentUrl().equals(Wiki.WIKIDOG)){
//            System.out.println("------PUrrrFECT-------");
//        }else{
//            System.out.println("-------NOPE-------");
//        }
        Assert.assertEquals(driver.getCurrentUrl(),Wiki.WIKIDOG);

        driver.quit();
    }

    @Test
    void scroll(){
        WebDriver driver = Helper.setupDriver();
        driver.get(Wiki.WIKICAT);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("alert('This is my message')");
//        driver.switchTo().alert().accept();

        jse.executeScript("window.scrollBy(0,1000)");

        jse.executeScript("window.scrollBy(0,-500)");

        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        jse.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");

        WebElement behaviour = driver.findElement(By.id("Behavior"));
        jse.executeScript("arguments[0].scrollIntoView();",behaviour);


    }

}
