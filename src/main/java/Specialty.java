import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Specialty {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/toster/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://specialty.ru/");

        WebElement header_item = driver.findElement(By.linkText("Кофе"));
        header_item.click();

        WebElement coffeeCardTitle = driver.findElement(By.xpath("//a[@title='Набор кофе Натуральный кофе Junight']"));
        coffeeCardTitle.click();

        driver.close();

    }
}
