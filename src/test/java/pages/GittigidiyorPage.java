package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.Random;

public class GittigidiyorPage {

    public GittigidiyorPage() {PageFactory.initElements(Driver.getDriver(), this);}
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @FindBy(xpath = "//*[@class='tyj39b-5 lfsBU']")
    public WebElement cookiesAccept;

    @FindBy(xpath = "//*[@class='sc-1yew439-3 bxSoKG']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[text()='BUL']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[text()='Sonraki']")
    public WebElement nextPageButton;

    public void selectProduct() throws InterruptedException {
        Random random=new Random();
        int count = random.nextInt(33);
        if (count<5){
            js.executeScript("window.scrollBy(0,250)");
        }else if (count<9){
            js.executeScript("window.scrollBy(0,750)");
        }else if (count<13){
            js.executeScript("window.scrollBy(0,1250)");
        }else if (count<17){
            js.executeScript("window.scrollBy(0,1750)");
        }else if (count<21){
            js.executeScript("window.scrollBy(0,2250)");
        }else if (count<25){
            js.executeScript("window.scrollBy(0,2750)");
        }else if (count<29){
            js.executeScript("window.scrollBy(0,3250)");
        }else {
            js.executeScript("window.scrollBy(0,3850)");
        }
        Thread.sleep(500);
        WebElement product=Driver.getDriver().findElement(By.xpath("(//*[@class='sc-1nx8ums-0 dyekHG'])["+count+"]"));
        Thread.sleep(500);
        product.click();
    }

    @FindBy(id = "sp-title")
    public WebElement productTitle;

    @FindBy(id = "sp-subTitle")
    public WebElement productFeature;

    @FindBy(xpath = "(//*[@id='sp-price-lowPrice'])[1]")
    public WebElement productPrice;

    @FindBy(xpath = "//*[@id='add-to-basket']")
    public WebElement addToBasket;

    @FindBy(xpath = "//*[@class='basket-container robot-header-iconContainer-cart']")
    public WebElement basket;

    @FindBy(xpath = "//*[@class='new-price']")
    public WebElement priceToPay;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement countDropdown;

    @FindBy(xpath = "(//a[@class='btn-delete btn-update-item'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']")
    public WebElement basketIsEmpty;
}