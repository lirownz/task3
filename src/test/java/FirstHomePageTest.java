import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstHomePageTest extends FirstBaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setup(){
        homePage = new HomePage(ffDriver);
    }

    @BeforeMethod
    public void setupMethod(){
        homePage.goToURL();
    }

    @Test (priority=1)
    public void checkPageTitle(){
        Assert.assertEquals(ffDriver.getTitle(),"QA Automation Tools Trainings and Tutorials | QA Tech Hub");
    }

    @Test (priority=2)
    public void navigateBack() {
        ffDriver.navigate().to("https://www.facebook.com");
        ffDriver.navigate().back();
    }

    @Test (priority=3)
    public void printCurrentURL() {
        System.out.println("*** Current URL is: "+ ffDriver.getCurrentUrl());
    }

    @Test (priority=4)
    public void navigateForward() {
        ffDriver.navigate().forward();
    }

    @Test (priority=5)
    public void reloadPage() {
        ffDriver.navigate().refresh();
    }

    @Test (priority=6)
    public void closeBrowser() {
        teardown();
    }
}
