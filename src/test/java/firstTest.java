import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class firstTest extends BaseTest{

    private void hoverOver(WebElement element){
        Actions hoverOver = new Actions(getDriver());
        hoverOver.moveToElement(element).perform();
    }

    private String saveOldWindow(){
        String winHandleBefore = getDriver().getWindowHandle();
        return winHandleBefore;
    }

    private void switchToNewWindow(){
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        JavascriptExecutor jsc = (JavascriptExecutor) getDriver();
        jsc.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    @Test
    public void testTitle(){
        String expectedTitle = "My Favorite Movies";

        String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void testH1HeaderDefaultView(){
        String expectedH1Header = "My Favorite Series";

        String actualH1Header = getDriver().findElement(By.xpath("//h1")).getText();

        Assert.assertEquals(actualH1Header, expectedH1Header);
    }

    @Test
    public void testH1HeaderHoverView(){
        String expectedH1Header = "MY FAVORITE SERIES";

        WebElement h1Header = getDriver().findElement(By.xpath("//h1"));
        hoverOver(h1Header);
        String actualH1Header = h1Header.getText();

        Assert.assertEquals(actualH1Header, expectedH1Header);
    }

    @Test
    public void testImgDefaultView() {
        String expectedSrc = getBaseURL() + "Assets/main_picture.jpg";
        int expectedWidth = 600;
        int expectedHeight = 331;
        String expectedAlt = "";
        String expectedWidthAttributeValue = "600";

        WebElement image = getDriver().findElement(By.xpath("//img"));
        List<WebElement> images = getDriver().findElements(By.xpath("//img"));

        Assert.assertTrue(image.isDisplayed());
        Assert.assertEquals(images.size(), 1);
        Assert.assertEquals(image.getSize().getWidth(), expectedWidth);
        Assert.assertEquals(image.getSize().getHeight(), expectedHeight);
        Assert.assertEquals(image.getAttribute("src"), expectedSrc);
        Assert.assertEquals(image.getAttribute("alt"),expectedAlt);
        Assert.assertEquals(image.getAttribute("width"), expectedWidthAttributeValue);
        Assert.assertEquals(image.getAttribute("border-radius"), null);
    }

    @Test
    public void testImgHoverView() {
        String expectedSrc = getBaseURL() + "Assets/main_picture.jpg";
        int expectedWidth = 600;
        int expectedHeight = 331;
        String expectedAlt = "";
        String expectedWidthAttributeValue = "600";
        String expectedBorderRadius = "50%";

        WebElement image = getDriver().findElement(By.xpath("//img"));
        hoverOver(image);
        WebElement imageHover = getDriver().findElement(By.cssSelector("img:hover"));

        Assert.assertTrue(imageHover.isDisplayed());
        Assert.assertEquals(imageHover.getSize().getWidth(), expectedWidth);
        Assert.assertEquals(imageHover.getSize().getHeight(), expectedHeight);
        Assert.assertEquals(imageHover.getAttribute("src"), expectedSrc);
        Assert.assertEquals(imageHover.getAttribute("alt"),expectedAlt);
        Assert.assertEquals(imageHover.getAttribute("width"), expectedWidthAttributeValue);
        Assert.assertEquals(imageHover.getCssValue("border-radius"), expectedBorderRadius);
    }

    @Test
    public void testJosephLinkNavigation() {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/joseph.html";
        String expectedTitle = "Joseph";
        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        getDriver().findElement(By.linkText("Prophet Joseph")).click();
        switchToNewWindow();

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testJosephLinkNavigation")
    public void testBackToMainPageFromJosephPageNavigation()  {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/index.html";
        String expectedTitle = "My Favorite Movies";

        getDriver().findElement(By.linkText("Prophet Joseph")).click();
        switchToNewWindow();

        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        scrollToElementAndClick(getDriver().findElement(By.linkText("back to Main page")));

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testOmarLinkNavigation() {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/omar.html";
        String expectedTitle = "Omar";
        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        getDriver().findElement(By.linkText("Omar Ibn Khattab")).click();
        switchToNewWindow();

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testOmarLinkNavigation")
    public void testBackToMainPageFromOmarPageNavigation()  {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/index.html";
        String expectedTitle = "My Favorite Movies";

        getDriver().findElement(By.linkText("Omar Ibn Khattab")).click();
        switchToNewWindow();

        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        scrollToElementAndClick(getDriver().findElement(By.linkText("back to Main page")));

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testMoonLinkNavigation() {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/moon.html";
        String expectedTitle = "Moon";
        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        getDriver().findElement(By.linkText("Qamar Bani Hashem")).click();
        switchToNewWindow();

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testMoonLinkNavigation")
    public void testBackToMainPageFromMoonPageNavigation()  {
        String expectedLink = "https://rafissabitov.github.io/favorite-movies/index.html";
        String expectedTitle = "My Favorite Movies";

        getDriver().findElement(By.linkText("Qamar Bani Hashem")).click();
        switchToNewWindow();

        String oldLink = getDriver().getCurrentUrl();
        String oldTitle = getDriver().getTitle();

        scrollToElementAndClick(getDriver().findElement(By.linkText("back to Main page")));

        String actualLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(actualLink, oldLink);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testBackgroundDefaultView() {
        String expectedBackgroundColor = "rgba(255, 199, 199, 1)";

        String background = getDriver().findElement(By.cssSelector("body")).getCssValue("background-color");

        Assert.assertEquals(background, expectedBackgroundColor);
    }

    @Test
    public void testBackgroundHoverView() {
        String expectedBackgroundColorHover = "rgba(168, 216, 234, 1)";

        WebElement background = getDriver().findElement(By.cssSelector("body"));//???
        hoverOver(background);
        String backgroundHover = getDriver().findElement(By.cssSelector("body")).getCssValue("background-color");

        Assert.assertEquals(backgroundHover, expectedBackgroundColorHover);
    }
}
