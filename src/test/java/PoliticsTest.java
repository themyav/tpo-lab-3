// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class PoliticsTest extends TestTemplate{
    @Override
    void doTest(WebDriver driver, JavascriptExecutor js) {
        driver.get("https://smi2.ru/");
        driver.manage().window().setSize(new Dimension(980, 1056));
        driver.findElement(By.xpath("//a[contains(@href, \'/topic/6\')]")).click();
        driver.findElement(By.xpath("//div[3]/div/span")).click();
        driver.findElement(By.xpath("//div[3]/div/span")).click();
        {
            WebElement element = driver.findElement(By.xpath("//div[3]/div/span"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        assertThat(driver.findElement(By.xpath("//div[3]/div/span")).getText(), is("ПОЛИТИКА"));
        driver.close();
    }
}