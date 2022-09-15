import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {

    public static final String BUTTONSURL = "https://demoqa.com/buttons";
    public static final String TEXTFIELDURL = "https://demoqa.com/text-box";
    public static final String FULLNAMEFIELD = "userName";
    public static final String DOUBLECLICKBTN = "doubleClickBtn";
    public static final String CONTEXTCLICKBTN = "rightClickBtn";
    public static final String ONECLICKBTN = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button";


    public static final String ALERTURL = "https://demoqa.com/alerts";
    public static final String REGULARALERT = "alertButton";
    public static final String TIMEALERTBTN = "timerAlertButton";
    public static final String CONFIRMBTN = "confirmButton";
    public static final String PROMPTBTN = "promtButton";




    public static ChromeDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","res\\chromedriver.exe");
        return new ChromeDriver();
    }

}
