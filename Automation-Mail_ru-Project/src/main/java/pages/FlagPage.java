package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlagPage {

    private WebDriver driver;

    public FlagPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//button[@title=\"Пометить флажком\"])[1]")
    private WebElement flag;

    @FindBy(xpath = "//button[@title=\"Пометить флажком\"]")
    private List<WebElement> flagList;

    @FindBy(xpath = "(//button[@title=\"Снять флажок\"])[1]")
    private WebElement deflag;

    @FindBy(xpath = "//button[@data-title=\"Снять флажок\" or @title=\"Снять флажок\"]")
    private List<WebElement> deflagList;

    private Logger logger = Logger.getLogger(FlagPage.class);

    public void selectFlag(WebDriver driver, int numberMessages) {
        do {
            new WebDriverWait(driver, 15).until(ExpectedConditions
                    .elementToBeClickable(flag)).click();

            (new WebDriverWait(driver, 15)).
                    until(ExpectedConditions.visibilityOfAllElements(deflagList));
        }
        while (deflagList.size() < numberMessages);
        logger.info("messages with flags");
   }

    public void deSelectFlag(WebDriver driver) {
        do {
            (new WebDriverWait(driver, 15)).
                    until(ExpectedConditions.visibilityOfAllElements(deflagList));
            new WebDriverWait(driver, 15).until(ExpectedConditions
                    .elementToBeClickable(deflag)).click();
            new WebDriverWait(driver, 15).until(ExpectedConditions
                    .visibilityOfAllElements(flagList));
        }
        while (deflagList.size() > 0);
        logger.info("messages without flags");
    }

    public boolean flagIsPresent(int numberMessages) {
        return (flagList.size() >= numberMessages);
    }

    public boolean flagIsNotPresent() {
        return flagList.isEmpty();
    }

}