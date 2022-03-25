package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.cachestorage.model.Header;
import pages.*;
import pages.SettingsPage;
import utils.DriverConfiguration;
import utils.YAMLDeserializer;
import tests.AuthorizedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.DriverConfiguration.USER_NAME;
import static utils.DriverConfiguration.USER_PASSWORD;

public class SettingsPageTest extends AuthorizedTest {
    protected SettingsPage settingsPage;
    protected HeaderPage headerPage;

    public SettingsPageTest() {
        super();
        settingsPage = new SettingsPage(driver);
        headerPage = new HeaderPage(driver);
    }

    /**
     * Test verify that user cannot update profile with invalid phone number
     */
    @Test
    public void verifyThatUserCannotInputInvalidPhoneNumber() {
        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();
        settingsPage.confirmNewPhoneNumber("16736849261412312");
        assertTrue(settingsPage.findMassageProfileUpdated(), "Phone number is invalid");
    }

    /**
     * Test verify that all elements on SettingsPage are displayed
     */
    @Test
    public void verifyThatAllElementsAreDisplayed() {
        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(settingsPage.findToolBar())
                .withFailMessage("Tbr isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findMenuButton())
                .withFailMessage("BtnMenu isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findFollowToLandingPageButton())
                .withFailMessage("BtnFollowToLandingPage isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findSelectLanguageMenuButton())
                .withFailMessage("BtnSelectLanguageMenu isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findHeadingProfile())
                .withFailMessage("HeadingProfile isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findGeneralInformationText())
                .withFailMessage("TextGeneralInformation isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findEmailField())
                .withFailMessage("FldEmail isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findPhoneNumberField())
                .withFailMessage("PhoneNumberField isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findUpdateProfileButton())
                .withFailMessage("BtnUpdateProfile isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findCurrentPasswordField())
                .withFailMessage("FldCurrentPassword isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findNewPasswordField())
                .withFailMessage("FldNewPassword isn't displayed").isTrue();
        softAssertions.assertThat(settingsPage.findSelectLanguageMenuButton())
                .withFailMessage("FldConfirmPassword isn't displayed").isTrue();

    }

    /**
     * Test verify that user cannot change password with different new and confirm values
     */
    @Test
    public void verifyThatPasswordCannotBeChangedWithDifferentNewAndConfirmValues() {
        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();
        settingsPage.confirmNewPassword("123456", "12345");
        assertTrue(settingsPage.findMassagePasswordConfirmation(), "Password confirmation does not match password");
    }
// //
    //
    //
    /**
     * Test verify that user cannot change password with incorrect current password
     */
    @Test
    public void verifyThatUserCannotChangePasswordWithIncorrectCurrentPassword() {
        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();
        settingsPage.confirmChangePassword("843hy8dh3698dhg", "843hy8dh3698dhg", "843hy8dh3698dhg");
        assertTrue(settingsPage.findMassagePasswordChange(), "Password confirmation does not match password");
    }

    /**
     * Test verify that user cann change password with correct current password, new password and confirm password values
     */
    @Test
    public void verifyThatUserAreAbleToChangePassword() {
        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();
        settingsPage.confirmChangePassword("843hy8dh3698dhg", "123456", "123456");
        assertTrue(settingsPage.findMassagePasswordChange(), "");
    }
    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        super.tearDown();
    }
}