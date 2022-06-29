import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


public class LandingPage extends PageBase{

    public LandingPage(WebDriver drv) {
        super(drv);
    }
    private final By logOutText = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By logoutButton = By.xpath("//*[@id=\"logout-link\"]");
    private final By gotoBlogButton = By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[7]");
    private final By seeAllPostButton = By.cssSelector("#blog > div.container > div.row.mb-5 > div:nth-child(2) > div > a");
    private final By profileButton = By.id("profile-btn");
    private final By contactme = By.xpath("//*[@id=\"navbarCollapse\"]/div/a");
    private final By ResumeButton = By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[5]/a");
    private final By expButton = By.xpath("//*[@id=\"resume\"]/div[2]/div/div[1]/div/div[2]/a[2]");
    public final By findText= By.xpath("//*[@id=\"i-am-here-for-your-personal-business\"]");
    private final By education = By.id("master-in-arts");
    private final By experience = By.xpath("//*[@id=\"experience\"]/div/h4");

    public String getLogOutText()
    {
        String result = driver.findElement(logOutText).getText();
        return result;
    }

    public void clickLogoutButton()
    {
        driver.findElement(logoutButton).click();
    }
    public void goToBlog()
    {
        driver.findElement(gotoBlogButton).click();
    }
    public void seeAllPosts()
    {
        driver.findElement(seeAllPostButton).click();
    }
    public void clickProfileButton()
    {
        driver.findElement(profileButton).click();
    }
    public void clickContactMe()
    {
        driver.findElement(contactme).click();
    }
    public void expButtonClick()
    {
        driver.findElement(expButton).click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {

        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void saveTextFromPage()
    {
        String text = driver.findElement(findText).getText();
        File f = new File("savetxt.txt");
        try{
            FileUtils.writeStringToFile(f, text, Charset.defaultCharset());
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }

    public boolean isFileSaved(String downloadPath, String fileName) {

        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }







    public void goToResume()
    {
        driver.findElement(ResumeButton).click();
    }

    public String[] readEducationRecords()
    {
        String[] names = null;
        List<WebElement> eduList = driver.findElements(education);
        names = new String[eduList.size()];
        for (int i = 0; i < eduList.size(); i++) {
            names[i] = eduList.get(i).getText();
        }
        return names;
    }
    public String[] readExperienceRecords()
    {
        String[] names = null;
        List<WebElement> eduList = driver.findElements(experience);
        names = new String[eduList.size()];
        for (int i = 0; i < eduList.size(); i++) {
            names[i] = eduList.get(i).getText();
        }
        return names;
    }






}
