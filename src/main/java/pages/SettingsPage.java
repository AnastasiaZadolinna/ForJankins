package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    private final By tbr = By.xpath
            ("//header[@class = 'MuiPaper-root MuiAppBar-root MuiAppBar-positionStatic MuiAppBar-colorPrimary MuiPaper-elevation0']");
    private final By btnMenu = By.xpath
            ("//div[@class='MuiToolbar-root MuiToolbar-regular MuiToolbar-gutters']//button");
    private final By imgLogo = By.cssSelector
            ("//img[src='/static/media/cardboard-box.e6f6462e.svg']");
    private final By btnFollowToLandingPage = By.xpath
            ("//a[@class='logo-link active']");
    private final By btnSelectLanguageMenu = By.xpath
            ("//div[@aria-haspopup='listbox']");
    private final By headingProfile = By.xpath
            ("//h5[contains(text(),'Profile')]");
    private final By textGeneralInformation = By.xpath
            ("//h6[contains(text(),'General information about you')]");
    private final By fldEmail = By.xpath
            ("//div [@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-marginDense MuiOutlinedInput-marginDense']");
    private final By textEmailHelper = By.xpath
            ("//p [@id='email-helper-text']");
    private final By btnPhoneRegion = By.xpath
            ("//button [@class'MuiButtonBase-root MuiButton-root MuiButton-text MuiPhoneNumber-flagButton']");
    private final By phoneNumberField = By.xpath
            ("//input [@id='phone']");
    private final By BtnUpdateProfile = By.cssSelector
            ("button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-containedSizeLarge.MuiButton-sizeLarge.MuiButton-disableElevation.MuiButton-fullWidth:nth-child(1)");
    private final By fldCurrentPassword = By.xpath
            ("//input [@id='current-password']");
    private final By fldNewPassword = By.xpath
            ("//input [@id='new-password']");
    private final By fldConfirmPassword = By.xpath
            ("//input [@id='password-confirmation']");
    private final By btnChangePassword = By.cssSelector
            ("div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-6 button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-containedSizeLarge.MuiButton-sizeLarge.MuiButton-disableElevation.MuiButton-fullWidth");
    private final By urlIForgotMyPassword = By.xpath
            ("//a [@href='/reset-password']");
    private final By massageProfileUpdated = By.xpath
            ("//form/div[3]");
    private final By massagePasswordConfirmation = By.xpath
            ("//*[@id='password-confirmation-helper-text']");
    private final By massagePasswordChange = By.xpath
            ("//form/div[4]/div[2]/p");

    /**
     * Find and click the phoneRegionButton
     */
    public SettingsPage clickPhoneRegionButton() {
        WebElement phoneRegionButtonFind = driver.findElement(btnPhoneRegion);
        phoneRegionButtonFind.click();
        return this;
    }

    /**
     *
     * @param password
     * @param confirm
     * @return
     */
    public SettingsPage changePassword(String password, String confirm){
        WebElement passwordInput = driver.findElement(fldNewPassword);
        passwordInput.sendKeys(password);
        WebElement confirmPassword = driver.findElement(fldConfirmPassword);
        confirmPassword.sendKeys(confirm);
        WebElement changePassword = driver.findElement(btnChangePassword);
        changePassword.click();
        return this;
    }
    public SettingsPage confirmNewPhoneNumber(String number){
        WebElement fieldPhoneNumb = driver.findElement(phoneNumberField);
        fieldPhoneNumb.sendKeys(number);
        WebElement btnUpdateProfileClk = driver.findElement(BtnUpdateProfile);
        btnUpdateProfileClk.click();
        return this;
    }
    public SettingsPage confirmNewPassword(String newPassword, String confirmPassword){
        WebElement fldNewPasswordInput = driver.findElement(fldNewPassword);
        fldNewPasswordInput.sendKeys(newPassword);
        WebElement fldConfirmPasswordInput = driver.findElement(fldConfirmPassword);
        fldConfirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }
    public SettingsPage confirmChangePassword(String currentPassword, String newPassword, String confirmPassword) {
        WebElement fldCurrentPasswordInput = driver.findElement(fldCurrentPassword);
        fldCurrentPasswordInput.sendKeys(currentPassword);
        WebElement fldNewPasswordInput = driver.findElement(fldNewPassword);
        fldNewPasswordInput.sendKeys(newPassword);
        WebElement fldConfirmPasswordInput = driver.findElement(fldConfirmPassword);
        fldConfirmPasswordInput.sendKeys(confirmPassword);
        WebElement btnChangePasswordClk = driver.findElement(btnChangePassword);
        btnChangePasswordClk.click();
        return this;
    }
    /**
     * Methods find elements on page
     */
    public boolean findToolBar() {return driver.findElement(tbr).isDisplayed();}
    public boolean findMenuButton() {return driver.findElement(btnMenu).isDisplayed();}
    public boolean findLogoImg() {return driver.findElement(imgLogo).isDisplayed();}
    public boolean findFollowToLandingPageButton() {return driver.findElement(btnFollowToLandingPage).isDisplayed();}
    public boolean findSelectLanguageMenuButton() {return driver.findElement(btnSelectLanguageMenu).isDisplayed();}
    public boolean findHeadingProfile() {return driver.findElement(headingProfile).isDisplayed();}
    public boolean findGeneralInformationText() {return driver.findElement(textGeneralInformation).isDisplayed();}
    public boolean findEmailField() {return driver.findElement(fldEmail).isDisplayed();}
    public boolean findEmailHelperText() {return driver.findElement(textEmailHelper).isDisplayed();}
    public boolean findPhoneRegionButton() {return driver.findElement(btnPhoneRegion).isDisplayed();}
    public boolean findPhoneNumberField() {return driver.findElement(phoneNumberField).isDisplayed();}
    public boolean findUpdateProfileButton() {return driver.findElement(BtnUpdateProfile).isDisplayed();}
    public boolean findCurrentPasswordField() {return driver.findElement(fldCurrentPassword).isDisplayed();}
    public boolean findNewPasswordField() {return driver.findElement(fldNewPassword).isDisplayed();}
    public boolean findConfirmPasswordField() {return driver.findElement(fldConfirmPassword).isDisplayed();}
    public boolean findChangePasswordButton() {return driver.findElement(btnChangePassword).isDisplayed();}
    public boolean findIForgotMyPasswordUrl() {return driver.findElement(urlIForgotMyPassword).isDisplayed();}
    public boolean findMassageProfileUpdated() {return driver.findElement(massageProfileUpdated).isDisplayed();}
    public boolean findMassagePasswordConfirmation() {return driver.findElement(massagePasswordConfirmation).isDisplayed();}
    public boolean findMassagePasswordChange() {return driver.findElement(massagePasswordChange).isDisplayed();}


}

