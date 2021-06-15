import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class SecondBaseTest{

    public WebDriver chDriver;

    @BeforeClass
    public void setUpTest() {
        //setting Chrome driver from Maven
        WebDriverManager.chromedriver().setup();
        //Create a Chrome driver. All test classes use this.
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown () {
        //setting FF driver to quit after finishing all tests
        chDriver.quit();
        System.out.println("Test Completed");

    }
}