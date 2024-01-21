import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCases extends  TestBase{
    @Test
    public void Basic_auth()
    {
        driver.findElement(By.xpath("//li[@class='ui-menuitem-submenu'][1]")).click();
        driver.findElement(By.xpath("//li[@id='menuform:m_auth']/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]")).click();
        String current=driver.getWindowHandle();
      Set<String> s=  driver.getWindowHandles();
      for (String ss:s)
      {
          driver.switchTo().window(ss);
      }

        driver.get("http://admin:testleaf@leafground.com:8090/login");
        driver.close();
        driver.switchTo().window(current);
        driver.close();
    }
    @Test
    public void alert()
    {
        driver.get(PropertyManager.getInstance().get_baseurl());
        driver.findElement(By.xpath("//li[@class='ui-menuitem-submenu'][2]")).click();
        driver.findElement(By.xpath("//li[@id='menuform:m_overlay']/a")).click();
        driver.findElement(By.id("j_idt88:j_idt91")).click();
       Alert a1= driver.switchTo().alert();
       a1.accept();
       driver.findElement(By.id("j_idt88:j_idt93")).click();
       driver.switchTo().alert().accept();
      String res_txt =driver.findElement(By.id("result")).getText();
        System.out.println(res_txt);
        driver.findElement(By.id("j_idt88:j_idt95")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt88:j_idt98"))).click();
        driver.findElement(By.id("j_idt88:j_idt100")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id=\"j_idt88:j_idt101\"]/div[1]/a/span"))).click();

    }
}
