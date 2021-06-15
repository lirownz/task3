import org.openqa.selenium.By;
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
        chDriver.findElement(By.cssSelector("#pageFooter > ul > li:nth-child(2) > a")).click();
        Assert.assertEquals(chDriver.getCurrentUrl(), "https://www.facebook.com/");
    }

    @Test(priority = 2)
    public void checkingCreateAnAcc() {
        chDriver.findElement(By.linkText("Create New Account")).isDisplayed();
    }


//    @Test(priority = 3)
//    public void registartion() {
//        //enter registration page
//        chDriver.findElement(By.linkText("Create New Account")).click();
//        //fill first name
//        chDriver.findElement(By.name("firstname")).sendKeys("firstName");
//        //fill sure name
//        chDriver.findElement(By.name("lastname")).sendKeys("lastName");
//        //fill email
//        chDriver.findElement(By.name("reg_email__")).sendKeys("0549999999");
//        //fill new password
//        chDriver.findElement(By.id("password_step_input")).sendKeys("password");
//        //fill birth month
//        Select month = new Select(chDriver.findElement(By.id("month")));
//        month.selectByValue("3");
//        //fill birth day
//        Select day = new Select(chDriver.findElement(By.id("day")));
//        day.selectByValue("24");
//        //fill birth year
//        Select year = new Select(chDriver.findElement(By.id("year")));
//        year.selectByValue("1988");
//        //select gender
//        Select gender = new Select(chDriver.findElement(By.className("sex")));
//        gender.selectByValue("1");
//        //clicking signUp button
//        chDriver.findElement(By.name("websubmit")).click();
//    }

    @Test(priority = 3 , dataProvider="testdata")
    public void registartion(String firstName, String lastName, String password, String phone) {
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
        month.selectByValue("3");
        //fill birth day
        Select day = new Select(chDriver.findElement(By.id("day")));
        day.selectByValue("24");
        //fill birth year
        Select year = new Select(chDriver.findElement(By.id("year")));
        year.selectByValue("1988");
        //select gender
        Select gender = new Select(chDriver.findElement(By.className("sex")));
        gender.selectByValue("1");
        //clicking signUp button
        chDriver.findElement(By.name("websubmit")).click();
    }

    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){
// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object [][] facebookData = new Object[1][4];
// Enter data to row 0 column 0
        facebookData[0][0]="EwaveFirst";
// Enter data to row 0 column 1
        facebookData[0][1]="EwaveLast";
// Enter data to row 1 column 0
        facebookData[0][2]="0509998888";
// Enter data to row 1 column 0
        facebookData[0][3]="EwavePass";
// return arrayobject to testscript
        return facebookData;
    }
}


