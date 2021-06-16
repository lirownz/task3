import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SecondHomePageTest extends SecondBaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setup() {
        homePage = new HomePage(chDriver);
    }

    @BeforeMethod
    public void setupMethod() {
        homePage.goToURL2();
    }

    @Test(priority = 1)
    public void checkRedirectingURL() {
        //making sure we are on the US version site
        chDriver.findElement(By.cssSelector("#pageFooter > ul > li:nth-child(2) > a")).click();
        //checking assertion to the current url
        Assert.assertEquals(chDriver.getCurrentUrl(), "https://www.facebook.com/");
    }

    @Test(priority = 2)
    public void checkingCreateAnAcc() {
        chDriver.findElement(By.linkText("Create New Account")).isDisplayed();
    }

    @Test(priority = 3 , dataProvider="testdata")
    public void registartion(String firstName, String lastName, String password, String phone){
        //enter registration page
        chDriver.findElement(By.linkText("Create New Account")).click();
        //fill first name
        chDriver.findElement(By.name("firstname")).clear();
        chDriver.findElement(By.name("firstname")).sendKeys(firstName);
        //fill sure name
        chDriver.findElement(By.name("lastname")).clear();
        chDriver.findElement(By.name("lastname")).sendKeys(lastName);
        //fill email
        chDriver.findElement(By.name("reg_email__")).clear();
        chDriver.findElement(By.name("reg_email__")).sendKeys(phone);
        //fill new password
        chDriver.findElement(By.id("password_step_input")).clear();
        chDriver.findElement(By.id("password_step_input")).sendKeys(password);
        //fill birth month
        Select month = new Select(chDriver.findElement(By.id("month")));
        month.selectByVisibleText("May");
        //fill birth day
        Select day = new Select(chDriver.findElement(By.id("day")));
        day.selectByVisibleText("3");
        //fill birth year
        Select year = new Select(chDriver.findElement(By.id("year")));
        year.selectByVisibleText("2001");
        //select gender
        WebElement gender = chDriver.findElement(By.cssSelector("input[name='sex'][value='2']"));
        gender.click();
        //clicking signUp button
        chDriver.findElement(By.name("websubmit")).click();
    }

    @DataProvider(name="testdata")
        public Object[][] TestDataFeed() {
            return new Object[][]{
                    {"EwaveFirst", "EwaveLast", "0509998888", "EwavePass"}
            };
    }

    @Test (priority=4)
    public void closeBrowser() {
        teardown();
    }
}


