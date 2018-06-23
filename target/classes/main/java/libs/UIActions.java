package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions
{
    Logger log;
    WebDriver driver;
    JavascriptExecutor jse;
    WebDriverWait webDriverWait;


    public UIActions(WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait(driver, 20);
    }

    /**
     * Method which click to element by ID
     * @param element
     */
    public void clickToElementById(String element){
        try {
            driver.findElement(By.id(element)).click();
            log.info("Element was clicked");
        } catch (Exception ex) {
            log.error("Can't click to an element");
        }
    }

    /**
     * General method 'click to element'
     * @param element
     */
    public void clickToElement(WebElement element)
    {
        try
        {
            //Refactoring. driver.findElement(element).click();
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            log.info("Element was clicked");
        }
        catch (Exception ex)
        {
            log.error("Can't click to the element");
        }
    }

    /** Method inputs value to the web element
     * @param element
     * @param value
     */
    public void inputToTextField(WebElement element, String value)
    {
        try
        {
            element.clear();
            element.sendKeys(value);
            log.info("Input value to element");
        }
        catch(Exception ex)
        {
            log.error("Can't input value to element");
        }
    }

    public void tickCheckBox(WebElement element, boolean isStatusResult)
    {
        if(((element.isSelected()) && !(isStatusResult))
                || !((element.isSelected()) && (isStatusResult)))
        {
            element.click();
        }
    }

    public void selectDropDownElemByValue(WebElement webElement, String value){
        webElement.findElement(By.xpath(".//option[contains(text(),'" + value + "')]")).click();
    }

    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect)
    {
        try
        {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.selectByVisibleText(textForSelect);
            log.info(textForSelect + " was selected in DD");
        }
        catch (Exception e)
        {
            log.error("Can't work with element");
        }
    }

    public boolean isElementPresent(WebElement element)
    {
        try
        {
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception ex)
        {
            return false;
        }
    }

    public boolean isVisibleAbdEnabled(WebElement element){
        try {

            if (element.isDisplayed() && element.isEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Something went wrong");
            throw new AssertionError("isVisibleAbdEnabled: Ooops!");
        }
    }

    public void scrollThePage(WebElement element)
    {
        try
        {
            driver.findElement(By.id("id_of_element"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (Exception ex)
        {
            log.error("Can't scroll the page");
        }

    }

    public void scrollDownInPixels(int pixels){

        try {
            jse.executeScript("scroll(0,"+ pixels +  ") ;");
        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollDownInPixels: Ooops!");
        }
    }

    public void scrollUpInPixels(int pixels){
        try {
            jse.executeScript("scroll(0,-"+ pixels +  ") ;");
        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollUpInPixels: Ooops!");
        }
    }


    public void scrollHorizontal(WebElement element){
        try {
            jse.executeScript("arguments[0].scrollIntoView();",element );

        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollHorizontal: Ooops!");
        }
    }

    public String getTextFromElement(WebElement element){
        try {
            return element.getText();
        } catch (Exception e) {
            log.error("Something went wrong");
            throw new AssertionError("getTextFromElement: Ooops!");
        }
    }

    public String getCurrentUrl(){
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            log.error("Can't get current url");
            throw new AssertionError("getCurrentUrl: Ooops!");
        }
    }
}

/**
 *  ДЗ:
 * 1. Вибір елемента з дроп даун. Його можна зробити декількомами методами.
 * 2. Перевірити чи існує елемент на сторінці і чи доступний він (активна кнопка для ведення даних).
 * 3. Проскролити сторінку вниз.
 * 4. Зчитати текст з елементу.
 *
 * Прописати різні сторінки, додати локатори, і можна починати писати методи для тестів.
 * Кінцевий результат - 5 авто тестів
 */
