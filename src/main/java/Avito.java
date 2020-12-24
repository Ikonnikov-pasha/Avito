import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Avito {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/toster/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.avito.ru/");

        Select category = new Select(driver.findElement(By.xpath("//*[@id='category']")));
        category.selectByValue("99");

        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Принтер");

        WebElement cityOrRegion = driver.findElement(By.xpath("//div[@data-marker='search-form/region']"));
        cityOrRegion.click();

        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");

        WebElement allButton = driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']"));
        allButton.click();

        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        WebElement showButton = driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-s-3-rn6 button-primary-1RhOG width-width-12-2VZLz']"));
        showButton.click();

        Select sortingByPrice = new Select(driver.findElement(By.xpath("//div[2]/select")));
        sortingByPrice.selectByValue("2");

        WebElement catalog = driver.findElement(By.xpath("//div[@data-marker='catalog-serp']"));

        List<WebElement> price = catalog.findElements(By.xpath("//div[@class='iva-item-body-NPl6W']"));
        for (int i = 0; i < 3; i++) {
            System.out.println(price.get(i).findElement(By.xpath("//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
        }
    }
}
