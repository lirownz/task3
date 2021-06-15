import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //Constructor
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //Page Variables
    String firstBaseURL = "http://qatechhub.com";
    String secondBaseURL = "http://www.fb.com";

    //Page Methods
    //Go to Homepage
    public HomePage goToURL(){
        driver.get(firstBaseURL);
        return this;
    }

    public HomePage goToURL2(){
        driver.get(secondBaseURL);
        return this;
    }
}