package tests.home_page;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pages.*;
import tests.AuthorizedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest extends AuthorizedTest {


    protected SettingsPage settingsPage;
    protected LoginPage loginPage;


    public MenuTest () {
        super();
        settingsPage = new SettingsPage(driver);
        loginPage = new LoginPage(driver);
    }

    /**
     * Test whether the Main button works
     */
    @Test
    public void testMainBtn() {

        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();

        menuPage.clkMainBtn();

        assertTrue(homePage.isInptFieldDsp(), "Main button don't work correctly");
    }

    // --------------------------------------------------------------------------------

    /**
     * Check whether the User Menu is displayed after user authorization
     */
    @Test
    public void testIsUserMenuDsp() {

        headerPage.clkMenuBtn();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(menuPage.isUserMainDsp())
                .withFailMessage("UserMain isn't displayed").isTrue();
        softAssertions.assertThat(menuPage.isUserParselDsp())
                .withFailMessage("UserParsel isn't displayed").isTrue();
        softAssertions.assertThat(menuPage.isUserSetingsDsp())
                .withFailMessage("UserSetings isn't displayed").isTrue();
        softAssertions.assertThat(menuPage.isUserLogOutDsp())
                .withFailMessage("UserLogOut isn't displayed").isTrue();

        menuPage.clkBurgerBtn();

        softAssertions.assertAll();
    }

   /**
     * Check the transition to the MyParcels page after click
     */
    @Test
    public void testUserParselBtn() {

        headerPage.clkMenuBtn()
                .clkUserParselBtn();

        assertTrue(myParcelsPage.isTrckNbrFldDisplayed(), "There is no SignUp item in the Menu");

    }

    /**
     * Check the transition to the Settings page after click
     */
    @Test
    public void testUserSettingsBtn() {

        headerPage.clkMenuBtn()
                .clkUserSettingsBtn();

        assertTrue(settingsPage.findHeadingProfile(), "Problem settins");
    }

}
