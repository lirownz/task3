import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class FirstBaseTest {

    public WebDriver ffDriver;

    @BeforeClass
    public void setUpTest() {
        //setting FF driver from Maven
        WebDriverManager.firefoxdriver().setup();
        //Create a FF driver. All test classes use this.
        ffDriver = new FirefoxDriver();
        ffDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown () {
        //setting FF driver to quit after finishing all tests
        ffDriver.quit();
        System.out.println("Test Completed");

    }
}