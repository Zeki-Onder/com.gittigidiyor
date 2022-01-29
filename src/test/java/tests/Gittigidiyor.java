package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.GittigidiyorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Gittigidiyor {
    GittigidiyorPage gittigidiyorPage = new GittigidiyorPage();
    Actions actions=new Actions(Driver.getDriver());
    static Logger log = Logger.getLogger(Gittigidiyor.class);

    @Test
    public void gittigidiyorSearch() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        gittigidiyorPage.cookiesAccept.click();
        gittigidiyorPage.searchBox.click();
        actions.sendKeys("bilgisayar").perform();
        gittigidiyorPage.searchButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,4250)");
        gittigidiyorPage.nextPageButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("=2"));
        gittigidiyorPage.selectProduct();
        log.info("Random product was selected");
        js.executeScript("window.scrollBy(0,250)");
        ReusableMethods.writeToTxt("productCotent",gittigidiyorPage.productTitle);
        ReusableMethods.writeToTxt("productCotent",gittigidiyorPage.productFeature);
        ReusableMethods.writeToTxt("productCotent",gittigidiyorPage.productPrice);
        gittigidiyorPage.addToBasket.click();
        Thread.sleep(1000);
        gittigidiyorPage.basket.click();
        Assert.assertTrue(ReusableMethods.readTxt("productCotent")
                .contains(gittigidiyorPage.priceToPay.getText()));
        Select select = new Select(gittigidiyorPage.countDropdown);
        select.selectByValue("2");
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("2"));
        gittigidiyorPage.deleteButton.click();
        Thread.sleep(500);
        Assert.assertTrue(gittigidiyorPage.basketIsEmpty.getText().contains("Sepetinizde ürün bulunmamaktadır."));

    }


    @After
    public void tearDown(){
        Driver.getDriver().quit();
    }

}
