package cloud.autotests.tests._kak_ne_nado_no_veselo.page_objects.steps;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests._kak_ne_nado_no_veselo.page_objects.steps.pages.LoginPage;
import cloud.autotests.tests._kak_ne_nado_no_veselo.page_objects.steps.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests")
@Tag("bad-practice")
@Tag("web")
@Tag("login")
class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    @Description("Bad practice - a step for every action, a lot of code")
    @DisplayName("Successful login with web react-native app")
    void successfulLogin() {
        loginPage.openPage();
        loginPage.verifyHeaderLabelHasText("Not authorized");

        loginPage.verifyAuthorizationFormExists();
        loginPage.setLogin(DEFAULT_LOGIN);
        loginPage.setPassword(DEFAULT_PASSWORD);
        loginPage.clickRememberMeCheckbox();
        loginPage.clickSubmitButton();

        mainPage.verifyAuthorizationFormDoesntExist();
        mainPage.verifyHeaderLabelHasText("Hello, " + DEFAULT_LOGIN + "!");
        mainPage.verifyPrivateContentExists();
    }

    @Test
    @Description("Bad practice - a step for every action, a lot of code + dsl")
    @DisplayName("Successful login with web react-native app")
    void successfulLoginDsl() {
        loginPage.openPage()
                .verifyHeaderLabelHasText("Not authorized");

        loginPage.verifyAuthorizationFormExists()
                .setLogin(DEFAULT_LOGIN)
                .setPassword(DEFAULT_PASSWORD)
                .clickRememberMeCheckbox()
                .clickSubmitButton();

        mainPage.verifyAuthorizationFormDoesntExist()
                .verifyHeaderLabelHasText("Hello, " + DEFAULT_LOGIN + "!");
        mainPage.verifyPrivateContentExists();
    }
}
