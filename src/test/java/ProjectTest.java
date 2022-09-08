import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

}
