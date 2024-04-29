import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

public class CountyTest extends TestTemplate{
    private Map<String, Object> vars= new HashMap<String, Object>();
    public String waitForWindow(int timeout, WebDriver driver) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @Override
    void doTest(WebDriver driver, JavascriptExecutor js) {
        driver.get("https://smi2.ru/");
        driver.manage().window().setSize(new Dimension(980, 1056));
        driver.findElement(By.xpath("//span")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.xpath("//span[contains(.,\'Белоруссия\')]")).click();
        vars.put("win9360", waitForWindow(2000, driver));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win9360").toString());
        driver.findElement(By.xpath("//nav/div/div")).click();
        assertThat(driver.findElement(By.xpath("//span")).getText(), is("Белоруссия"));
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        driver.close();
    }
}
