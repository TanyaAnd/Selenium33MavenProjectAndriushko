package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions
{
    WebDriver driver;
    Logger log;
    WebDriverWait webDriverWait;

    public UIActions(WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait(driver, 20);
    }
    /**
     * General method 'click to element'
     * @param element
     */
    public void clickToElement(WebElement element)
    {
        try
        {
            //driver.findElement(element).click();
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            log.info("Element was clicked");
        }
        catch (Exception ex)
        {
            log.error("Can't click to the element");
        }
    }

    /** Method inputs value to web element
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
}

/**
 *  ДЗ:
 * 1. Вибір елемента з дроп даун. Його можна зробити декількомами методами.
 * 2. Перевірити чи існує елемент на сторінці і чи доступний він (активна кнопка для ведення даних).
 * 3. Проскролити сторінку вниз.
 * 4. Зчитати текст з елементу.
 *
 * Прописати різні сторінки, додати локатори, і можна починати писати метод.
 * Кінцевий результат - 5 авто тестів
 */
