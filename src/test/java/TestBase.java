import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public Wait<WebDriver> wait;
    @BeforeMethod
    public void base()
    {
        if(PropertyManager.getInstance().get_browser().equalsIgnoreCase("edge"))
        {
           // System.out.println("entered");
            WebDriverManager.edgedriver().setup();
            EdgeOptions options=new EdgeOptions();
            options.addArguments("start-maximized");
            driver=new EdgeDriver(options);
            driver.navigate().to(PropertyManager.getInstance().get_baseurl());

        }
       wait=new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(30))
               .pollingEvery(Duration.ofSeconds(5))
               .ignoring(Exception.class);
    }
    @AfterClass
    public void logout()
    {
        //driver.close();
    }
}
