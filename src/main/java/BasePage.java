import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(String pageTitle) {
        return pageTitle;
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public void minimize(){
        driver.manage().window().setPosition(new Point(0, -2000));
    }
}