package tests;

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
import utilities.Log4j;

public class Gittigidiyor {
    GittigidiyorPage gittigidiyorPage = new GittigidiyorPage();
    Actions actions = new Actions(Driver.getDriver());
    Log4j log4j = new Log4j();

    @Test
    public void gittigidiyorSearch() throws InterruptedException {

        log4j.info("Test starting");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        log4j.info("Gittigidiyor Homepage opened");

        gittigidiyorPage.cookiesAccept.click();
        log4j.info("Cokies accepted");

        gittigidiyorPage.searchBox.click();
        actions.sendKeys("bilgisayar").perform();
        gittigidiyorPage.searchButton.click();
        log4j.info("searched by typing 'bilgisayar' in the text box");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,4250)");
        gittigidiyorPage.nextPageButton.click();
        log4j.info("Skipped to second page");

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("=2"));
        log4j.info("Verified that the second page was opened");

        gittigidiyorPage.selectProduct();
        log4j.info("Selected the random product");

        js.executeScript("window.scrollBy(0,250)");
        ReusableMethods.writeToTxt("productCotent", gittigidiyorPage.productTitle);
        ReusableMethods.writeToTxt("productCotent", gittigidiyorPage.productFeature);
        ReusableMethods.writeToTxt("productCotent", gittigidiyorPage.productPrice);
        log4j.info("Product feature written to txt file");

        gittigidiyorPage.addToBasket.click();
        log4j.info("Product add to cart");

        Thread.sleep(1000);
        gittigidiyorPage.basket.click();
        Assert.assertTrue(ReusableMethods.readTxt("productCotent")
                .contains(gittigidiyorPage.priceToPay.getText()));
        log4j.info("Verified that product price and price in the cart are equal ");

        Select select = new Select(gittigidiyorPage.countDropdown);
        select.selectByValue("2");
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("2"));
        log4j.info("Number of products increased to two and verified this");

        gittigidiyorPage.deleteButton.click();
        log4j.info("Deleted the product at cart");

        Thread.sleep(500);
        Assert.assertTrue(gittigidiyorPage.basketIsEmpty.getText()
                .contains("Sepetinizde ürün bulunmamaktadır."));
        log4j.info("Verified that the cart is empty");

        Driver.getDriver().quit();
        log4j.info("Test ending...");

    }
}
