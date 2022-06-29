import org.openqa.selenium.*;


public class Login extends PageBase {
    public Login(WebDriver drv) {
        super(drv);
    }
    private final String url = "https://lennertamas.github.io/portio/";
    private final By username = By.id("email");
    private final By password = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
    private final By resultMessage = By.id("alert");

    public void navigate() {
        driver.navigate().to(url);
    }
    public void setUserName(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String getResult() {
        String result = driver.findElement(resultMessage).getText();

        return result;
    }

    public void clickLoginTab()
    {
        WebElement loginTab  = driver.findElement(By.xpath("(//*[@id=\"login-form-button\"])[2]"));
        loginTab.click();
    }

    //Register form

    private final By termsandcond = By.id("terms-and-conditions-button");
    private final By xButton = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    private final By regUsername = By.id("register-username");
    private final By regPassword = By.id("register-password");
    private final By email = By.id("register-email");
    private final By description = By.id("register-description");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By topRegisterButton = By.id("register-form-button");
    private final By resultRegisterMessage = By.id("register-alert");

    public void acceptModal(){driver.findElement(termsandcond).click();}
    public void closeModal(){driver.findElement(xButton).click();}
    public void addUsername(String user) {
        driver.findElement(regUsername).sendKeys(user);
    }
    public void addPassword(String pass) {
        driver.findElement(regPassword).sendKeys(pass);
    }
    public void addEmail(String emailadd) {
        driver.findElement(email).sendKeys(emailadd);
    }
    public void addDescription(String desc) {
        driver.findElement(description).sendKeys(desc);
    }
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickOnTopRegisterButton() {
        driver.findElement(topRegisterButton).click();
    }

    public String getRegisterResult() {
        String result = driver.findElement(resultRegisterMessage).getText();
        System.out.println(result);
        return result;
    }

    public void registratefromtext(String[] datasArray)
    {   driver.findElement(regUsername).sendKeys(datasArray[0]);
        driver.findElement(regPassword).sendKeys(datasArray[1]);
        driver.findElement(email).sendKeys(datasArray[2]);
        driver.findElement(description).sendKeys(datasArray[3]);
        driver.findElement(registerButton).click();
    }

    public void clearForm()
    {   driver.findElement(regUsername).clear();
        driver.findElement(regPassword).clear();
        driver.findElement(email).clear();
        driver.findElement(description).clear();
    }
}


