import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Comment extends PageBase {
    public Comment(WebDriver drv) {
        super(drv);
    }
    private final By name = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[1]/input");
    private final By email = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[2]/input");
    private final By message = By.id("message");
    private final By agree = By.id("aggrement");
    private final By sendButton = By.id("contact-form-button");
    private final By resultMessage = By.id("contact-form-status");

    public void fillName(String addName) {
        driver.findElement(name).sendKeys(addName);
    }
    public void fillEmail(String addEmail) {
        driver.findElement(email).sendKeys(addEmail);
    }
    public void fillMessage(String addMessage) {
        driver.findElement(message).sendKeys(addMessage);
    }
    public void AgreeTerms()
    {
        driver.findElement(agree).click();
    }
    public void SendMessage()
    {
        driver.findElement(sendButton).click();
    }
    public String getResult()
    {
        String result = driver.findElement(resultMessage).getText();
        return result;
    }

}





