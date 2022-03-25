package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private final By tbr = By.xpath
            ("//header[@class='MuiPaper-root MuiAppBar-root MuiAppBar-positionStatic MuiAppBar-colorPrimary MuiPaper-elevation0']");
    private final By btnMenu = By.xpath
            ("//div[@class='MuiToolbar-root MuiToolbar-regular MuiToolbar-gutters']//button");
    private final By imgLogo = By.cssSelector
            ("img[src='/static/media/cardboard-box.e6f6462e.svg']");
    private final By lnkLogo = By.xpath
            ("//a[@class='logo-link active']");
    private final By btnListBox = By.xpath
            ("//div[@aria-haspopup='listbox']");
    private final By uaBtnLanguage = By.xpath
            ("//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']");
    private final By engBtnLanguage = By.xpath
            ("//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']");


    /**
     * Find and click on buttonOfMenu
     */
    public MenuPage clkMenuBtn() {
        waitElementIsVisible(btnMenu).click();
        return new MenuPage(driver);
    }

    /**
     * Find and click on Trackster link
     */
    public HeaderPage clkLnkLogo() {
        driver.findElement(lnkLogo).click();
        return this;
    }

    /**
     * Find and click to buttonForSelectMenuOfLanguage
     */
    public HeaderPage clkListBoxBtn() {
        driver.findElement(btnListBox).click();
        return this;
    }

    /**
     * Click ENG button to change Language on Page
     */
    public HeaderPage clkEngBtn() {
        WebElement engBtn = waitElementIsVisible(engBtnLanguage);
        engBtn.click();
        return this;
    }

    /**
     * Click UA button to change Language on Page
     */
    public HeaderPage clkUaBtn() {
        WebElement uaBtn = waitElementIsVisible(uaBtnLanguage);
        uaBtn.click();
        return this;
    }

    /**
     * Methods find elements on page
     */
    public boolean isTbrDsp() {

        return driver.findElement(tbr).isDisplayed();
    }
    public boolean isImgLogoDsp() {

        return driver.findElement(imgLogo).isDisplayed();
    }
    public boolean isBtnMenuDsp() {

        return driver.findElement(btnMenu).isDisplayed();
    }
    public boolean isLnkLogoDsp() {

        return driver.findElement(lnkLogo).isDisplayed();
    }
    public boolean isBtnListBoxDsp() {

        return driver.findElement(btnListBox).isDisplayed();
    }
}
