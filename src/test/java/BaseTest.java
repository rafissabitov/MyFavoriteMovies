import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    private String baseURL = "https://rafissabitov.github.io/favorite-movies/";

    protected WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    protected String getBaseURL(){
        return baseURL;
    }

    @BeforeMethod
    protected void beforeMethod(){
        getDriver().get(getBaseURL());
    }

    @AfterMethod
    protected void afterMethod(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
