import DriverFactory.DriverManager;
import DriverFactory.DriverManagerFactory;
import DriverFactory.DriverType;
import Utils.TestDataReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    DriverManager driverManager;

    protected TestDataReader testData;
    private String testDataLocation = "src/test/java/TestData.properties";


    private void getConfiguration() {
        testData = new TestDataReader(testDataLocation);
    }

    @BeforeAll
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        getConfiguration();
    }

    @BeforeEach
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterMethod() {
        driverManager.quitDriver();
    }
//


}
