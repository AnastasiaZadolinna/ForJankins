package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    private final By createYourAcc = By.cssSelector
            ("h4.MuiTypography-root.MuiTypography-h4.MuiTypography-gutterBottom");
    private final By fldEmail = By.id("email");
    private final By fldPassword = By.id("pasword");
    private final By fldConfirmPassword = By.id("password-confirmation");
    private final By btnSighUp = By.cssSelector
            ("button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-containedSizeLarge.MuiButton-sizeLarge.MuiButton-disableElevation");
    private final By loginWithGoogle = By.cssSelector
            ("a.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-containedSizeLarge.MuiButton-sizeLarge.MuiButton-disableElevation.MuiButton-fullWidth  span.MuiButton-label span.MuiButton-startIcon.MuiButton-iconSizeLarge:nth-child(1)");
    private final By loginWithFacebook = By.xpath
            ("//span[contains(text(), 'Login with Facebook')]");
    private final By logInUrl = By.xpath
            ("//span//a[@href='/login']");
    private final By massageInvalidEmail = By.xpath
            ("//p[@id='email-helper-text']");

    public SignupPage inputNewEmail(String newEmail, String password, String confirmPassword){
        waitElementIsVisible(fldEmail).sendKeys(newEmail);
        waitElementIsVisible(fldPassword).sendKeys(password);
        waitElementIsVisible(fldConfirmPassword).sendKeys(confirmPassword);
        WebElement btnSignUpClk = driver.findElement(btnSighUp);
        btnSignUpClk.click();
        return this;
    }


    /**
     *  Methods find elements on page
     */

    public boolean findCreateYourAcc() {return driver.findElement(createYourAcc).isDisplayed();}
    public boolean findEmailFld() {return driver.findElement(fldEmail).isDisplayed();}
    public boolean findPasswordFld() {return driver.findElement(fldPassword).isDisplayed();}
    public boolean findConfirmPasswordFld() {return driver.findElement(fldConfirmPassword).isDisplayed();}
    public boolean findSignUpBtn() {return driver.findElement(btnSighUp).isDisplayed();}
    public boolean findLoginWithGoogle() {return driver.findElement(loginWithGoogle).isDisplayed();}
    public boolean findLoginWithFacebook() {return driver.findElement(loginWithFacebook).isDisplayed();}
    public boolean findLogInUrl() {return driver.findElement(logInUrl).isDisplayed();}
    public boolean findMassageInvalidEmail() {return driver.findElement(massageInvalidEmail).isDisplayed();}

    private final By signUpImg = By.cssSelector("div.MuiGrid-root.MuiGrid-container");


//    public boolean isSignUpImgDsp() {
//        return driver.findElement(signUpImg).isDisplayed();
//    }
//
//    public ForgotPasswordPage clkSignUpImgBtn() {
//        driver.findElement(signUpImg).click();
//        return new ForgotPasswordPage(driver);
//    }

    public boolean isSignUpImgDsp() {
        return driver.findElement(signUpImg).isDisplayed();
    }
}
