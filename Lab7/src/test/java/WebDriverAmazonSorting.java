import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverAmazonSorting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.amazon.com/");

        WebElement searchInput = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchInput.sendKeys("iphone 11");

        WebElement searchBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'nav-search-submit-text\']/input")));
        searchBtn.click();

        WebElement sortForm = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"a-autoid-2\"]/span")));
        sortForm.click();

        WebElement sortByFromLowToHighPriceBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"s-result-sort-select_1\"]")));
        sortByFromLowToHighPriceBtn.click();

        driver.quit();
    }

    @Test
    public void WebDriverAmazonSortingTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.amazon.com/");

        WebElement searchInput = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchInput.sendKeys("iphone 11");

        WebElement searchBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'nav-search-submit-text\']/input")));
        searchBtn.click();

        WebElement sortForm = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[2]/div/div/form")));
        sortForm.click();

        WebElement sortByFromLowToHighPrice = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"s-result-sort-select_1\"]")));
        sortByFromLowToHighPrice.click();

        List <WebElement> listElements = driver.findElements(By.xpath("//span[@class='a-price-whole'"));
        int size= listElements.size();

        Assert.assertTrue(sortElements.equals(listElements));
        driver.quit();
    }
}