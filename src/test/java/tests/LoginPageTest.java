package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import utils.DriverConfiguration;
import utils.YAMLDeserializer;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("All tests for LoginPage")

public class LoginPageTest extends BaseTest {

    protected ForgotPasswordPage forgotPasswordPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected MyParcelsPage myParcelsPage;

    public static String USER_NAME;
    public static String USER_PASSWORD;
    public static String INVALID_USER_NAME;
    public static String INVALID_USER_PASSWORD;
    private static String USER_NAME_WITHOUT_PARCELS;
    private static String USER_PASSWORD_WITHOUT_PARCELS;

    public LoginPageTest() {
        super();
        forgotPasswordPage = new ForgotPasswordPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        myParcelsPage = new MyParcelsPage(driver);
    }

    @BeforeAll
    public static void beforeAll() {
        USER_NAME = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("user_name");
        USER_PASSWORD = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("user_password");
        INVALID_USER_NAME = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("invalid_user_name");
        INVALID_USER_PASSWORD = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("invalid_user_password");
        USER_NAME_WITHOUT_PARCELS = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("user_name_without_parcels");
        USER_PASSWORD_WITHOUT_PARCELS = YAMLDeserializer.fromFileToMap("login_test_data.yaml").get("user_password_without_parcels");
    }

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();
        loginPage = headerPage.clkMenuBtn()
                .clkLoginBtn();
    }

    @Test
    @DisplayName("Verify that all elements on LoginPage are displayed.")
    @Description("The test for all elements searching by Xpath and CSS selectors")

    public void verifyThatAllElementsAreDisplayed() {

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.isLogInYourAccountTxtDsp())
                .withFailMessage("Log in your account text isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isEmailFieldBtnDsp())
                .withFailMessage("Email Field isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isPasswordFieldDsp())
                .withFailMessage("Password Field isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isLoginBtnDsp())
                .withFailMessage("Login Button isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isForgotPasswordBtnDsp())
                .withFailMessage("Forgot Password Button isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isLoginWithGoogleBtnDsp())
                .withFailMessage("Login with google Button isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isLoginWithFacebookDsp())
                .withFailMessage("Login with google facebook isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isLoginPageLogoImageDsp())
                .withFailMessage("login page image logo isn't displayed").isTrue();
        softAssertions.assertThat(loginPage.isDontHaveAnAccountTxtDsp())
                .withFailMessage("Don't have an account text isn't displayed").isTrue();
    }

    @Test
    @DisplayName("Verify that error message \"Email is invalid\" is displayed when user login with invalid email")
    @Description("We using the 'invalidLogin'  method from 'LoginPage' and enter the INVALID_USER_NAME from 'login_test_data.yaml' file" +
            "to verify that the error 'Email is invalid' is displayed")
    public void loginTestWhenTheEmailInvalid() {
        loginPage.invalidLogin(INVALID_USER_NAME, USER_PASSWORD);
        assertTrue(loginPage.isErrorTextEmailIsntValidDispl(), "Error Text 'Email is invalid' isn't displayed when the user is enter the invalid email");
    }

    @Test
    @DisplayName("Verify that error message \"Incorrect email or password\" is displayed when user login with invalid password")
    @Description("We using the 'invalidLogin'  method from 'LoginPage' and enter the INVALID_USER_PASSWORD from 'login_test_data.yaml' file" +
            "to verify that the error 'Incorrect email or password' is displayed")
    public void loginTestWhenThePasswordInvalid() {
        loginPage.invalidLogin(USER_NAME, INVALID_USER_PASSWORD);
        assertTrue(loginPage.isErrorMessageIncorrectEmailOrPasswordDispl(), "Error message 'Incorrect email or password' isn't displayed when the user is enter the invalid password");

    }

    @Test
    @DisplayName("Verify that the parcel '59000779201387' are displayed on the parcel page")
    @Description("\"We using the 'validLogin' method from 'LoginPage' and search the parcel by the track number '59000779201387'")
    public void loginAsUserWithParcels() {

        String actual = loginPage.validLogin(USER_NAME, USER_PASSWORD)
                .getParcelNumber();
        assertTrue(myParcelsPage.isNmbParcelDisplayed(), "The parcels isn't displayed");
        assertEquals(actual, "59000779201387");
    }

    @Test
    @DisplayName("Verify that the 'Nothing found...' image is displayed on the parcel page")
    @Description("We using the 'validLogin' method from 'LoginPage' and search the image on user without parcels")
    public void loginAsUserWithoutParcels() {

        loginPage.validLogin(USER_NAME_WITHOUT_PARCELS, USER_PASSWORD_WITHOUT_PARCELS);
        assertTrue(myParcelsPage.isNothinfFoundImgDisplayed(), "The 'Nothing found...' image isn't displayed");
    }
}


//    @ParameterizedTest
//    @MethodSource("invalidCredentials")
//    public void loginTestInvalidCredentials(String name, String password, String errorMessage) {
//        homePage.clkMenuBtn()
//                .clkLoginBtn()
//                .insertLoginFld(name, password)
//                .clkSubmitLogin();
//        assertTrue(loginPage.isErrorMessageIncorrectEmailOrPasswordDispl(), errorMessage);
//    }
//
//    private static Stream<Arguments> invalidCredentials() {
//        return Stream.of(
//                Arguments.of(INVALID_USER_NAME, USER_PASSWORD, "Error Text Email Isn't Valid isn't displayed when the user is logged in"),
//                Arguments.of(USER_NAME, INVALID_USER_PASSWORD, "Incorrect email or password Isn't Vali isn't displayed when the user is logged in")
//        );
//    }

