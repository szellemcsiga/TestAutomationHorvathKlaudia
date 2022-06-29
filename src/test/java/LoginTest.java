import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import jdk.jfr.Name;

import org.junit.jupiter.api.*;


public class LoginTest extends TestPageBase{

    @Name("validLogin")
    @Tag("Functional Test")
    @DisplayName("Valid Login Test")
    @Description("Verify if a user will be able to login with a valid username and valid password.")
    @Test
    public void validLogin() throws InterruptedException
    {

        Main main = new Main(driver);
        main.SignInTest();

        Login login = new Login(driver);
        LandingPage landingPage = new LandingPage(driver);

        Thread.sleep(1500);
        login.clickLoginTab();
        login.setUserName("username");
        login.setPassword("Jelszo01");

        login.clickOnLoginButton();
        String result = landingPage.getLogOutText();

        Assertions.assertEquals(result, "Logout");
    }

    @Name("invalidLogin")
    @Tag("Functional Test")
    @DisplayName("InValid Login Test")
    @Description("Verify if a user cannot login with a valid username and an invalid password.")
    @Test
    public void inValidLogin() throws InterruptedException {

        Main main = new Main(driver);
        main.SignInTest();

        Login login = new Login(driver);

        Thread.sleep(1500);
        login.clickLoginTab();
        login.setUserName("username");
        login.setPassword("Jelszo00");
        login.clickOnLoginButton();
        String result = login.getResult();

        Assertions.assertEquals(result, "Username or Password\n" +
                "is not correct!");

    }
    @Name("missingDataLogin")
    @Tag("Functional Test")
    @DisplayName("Login with missing data")
    @Description("Verify the login page for both, when the field is blank and Submit button is clicked.")
    @Test
    public void MissingDetailsLogin() throws InterruptedException {

        Main main = new Main(driver);
        main.SignInTest();

        Login login = new Login(driver);


        Thread.sleep(1500);
        login.clickLoginTab();
        login.setUserName("username");
        login.setPassword("");
        login.clickOnLoginButton();
        String result = login.getResult();

        Assertions.assertEquals(result, "Username or Password\n" +
                "is not correct!");

    }


    @Name("logoutTest")
    @Tag("Functional Test")
    @DisplayName("Logout Test with button")
    @Description("Verifying that the logout button is working correctly")
    @Test

    public void logout() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();

        Login login = new Login(driver);
        LandingPage landingPage = new LandingPage(driver);
        popUp pop = new popUp(driver);


        Thread.sleep(1500);
        login.clickLoginTab();
        login.setUserName("username");
        login.setPassword("Jelszo01");

        login.clickOnLoginButton();
        Thread.sleep(2500);
        landingPage.clickLogoutButton();
        String result = pop.getOut();

        Assertions.assertEquals(result, "Terms and conditions");
    }
}
