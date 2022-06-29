import com.thoughtworks.qdox.model.expression.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile extends PageBase {

    public Profile(WebDriver drv) {
        super(drv);
    }

    private final By name = By.id("name");
    private final By bio = By.id("bio");
    private final By phone = By.id("phone-number");
    private final By resultMessage = By.id("edit-alert");
    private final By saveProfil = By.id("edit-profile");
    private final By deleteProfileButton = By.xpath("//*[@id=\"edit-profile\"]/form/div[6]/button");
    private final By deleteForSure = By.id("delete-account-btn");

    public void fillName(String addName) {
        driver.findElement(name).sendKeys(addName);
    }
    public void fillBio(String addBio) {
        driver.findElement(bio).sendKeys(addBio);
    }
    public void fillPhoneNumber(String addPhone) {
        driver.findElement(phone).sendKeys(addPhone);
    }
    public void saveTheProfil()
    {
        driver.findElement(saveProfil).click();
    }
    public void deleteProfile()
    {
        driver.findElement(deleteProfileButton).click();
    }
    public void sureDelete()
    {
        driver.findElement(deleteForSure).click();
    }

    public String getResult() {
        String result = driver.findElement(resultMessage).getText();
        return result;
    }

    public void clearForm() {
        driver.findElement(name).clear();
        driver.findElement(bio).clear();
        driver.findElement(phone).clear();
    }

}