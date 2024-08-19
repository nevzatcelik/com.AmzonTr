package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static utils.Driver.driver;

public class NotebookPage {
    public NotebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Windows 11 Home'])[2]")
    public WebElement windows11Button;

    @FindBy(xpath = "//*[@class='a-button-text a-declarative']")
    public WebElement sortingDropDownMenu;

    @FindBy(xpath = "//a[text()='Fiyat: Düşükten Yükseğe']")
    public WebElement lowToHighPrice;

    @FindBy(xpath = "//*[text()='Fiyat: Yüksekten Düşüğe']")
    public WebElement highToLowPrice;
    @FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[1]")
    public WebElement freeDeliveryCheckBox;

    @FindBy(xpath = "//*[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultProduct;

    public void allWin11ProductVerification() {
        List<WebElement> products = Driver.getDriver().findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']"));
        if (products.size() > 0) {
            System.out.println("Total products found: " + products.size());
            for (WebElement product : products) {
                Assert.assertTrue(product.getText().contains("11"));
            }
        } else {
            System.out.println("no products found");
        }
    }

    public void sortingLowToHighVerification() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//*[@class='a-price']"));
        List<Integer> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {

            String priceText = priceElement.getText().replaceAll("\\D", "");

            try {
                int price = Integer.parseInt(priceText);
                price = price / 100;
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse price: " + priceText);
            }

        }
        prices.sort(Integer::compareTo);

        for (Integer price : prices) {
            System.out.println(price);
        }
        List<Integer> originalPrices = new ArrayList<>(prices);
        Assert.assertEquals(prices, originalPrices);
    }

    public void sortingHighToLowVerification() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//*[@class='a-price']"));
        List<Integer> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {

            String priceText = priceElement.getText().replaceAll("\\D", "");
            try {
                int price = Integer.parseInt(priceText);
                price = price / 100;
                prices.add(price);

            } catch (NumberFormatException e) {
                System.out.println("Could not parse price: " + priceText);
            }

        }
        prices.sort(Comparator.reverseOrder());

        for (Integer price : prices) {
            System.out.println(price);
        }
        List<Integer> originalPrices = new ArrayList<>(prices);
        Assert.assertEquals(prices, originalPrices);
    }


    public void allProductFreeDeliveryw11(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> products = driver.findElements(By.xpath("//*[@data-component-type='s-search-result']"));
        String totalProdcuts=resultProduct.getText();
        totalProdcuts=totalProdcuts.replaceAll("\\D","");
        for (int i = 0; i < Integer.parseInt(totalProdcuts); i++) {
            WebElement product = products.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(product)).click();

            try {
                WebElement freeDeliveryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='a-link-normal'])[1]")));
                Assert.assertTrue(freeDeliveryElement.getText().contains("ÜCRETSİZ teslimat"));
                System.out.println("This product is free delivery");
            } catch (NullPointerException e) {
                System.out.println("This product is not delivery");
            }

            driver.navigate().back();


            products = driver.findElements(By.xpath("//*[@data-component-type='s-search-result']"));
        }
    }
    }






