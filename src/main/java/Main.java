import org.openqa.selenium.WebDriver;

public class  Main extends PageBase {

    public Main(WebDriver drv) {
        super(drv);
    }


    public void SignInTest()
    {
        Login signin = new Login(driver);
        signin.navigate();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        signin.clickOnTopRegisterButton();
        signin.addUsername("username");
        signin.addPassword("Jelszo01");
        signin.addEmail("dfsf@ggr.hu");
        signin.addDescription("-");
        signin.clickOnRegisterButton();

    }
    public void loginTest()
    {
        Login login = new Login(driver);
        LandingPage landingPage = new LandingPage(driver);

        login.clickLoginTab();
        login.setUserName("username");
        login.setPassword("Jelszo01");

        login.clickOnLoginButton();
    }

}