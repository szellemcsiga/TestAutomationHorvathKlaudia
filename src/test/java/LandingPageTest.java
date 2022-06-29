import jdk.jfr.Description;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class LandingPageTest extends TestPageBase {

    @Name("SaveImageFileOnSite")
    @Tag("Functional Test")
    @DisplayName("Save image file")
    @Description("Verify whether an image can be saved from the page")
    @Test
    public void saveImageFileOnSite() {
        try {

            Main main = new Main(driver);
            main.SignInTest();
            main.loginTest();
            Thread.sleep(1500);


            WebElement logo = driver.findElement(By.xpath("//*[@id=\"home\"]/div[3]/div/div[2]/div/img"));
            String logoSRC = logo.getAttribute("src");

            URL imageURL = new URL(logoSRC);
            BufferedImage saveImage = ImageIO.read(imageURL);

            ImageIO.write(saveImage, "png", new File("profilePicture.png"));

        } catch (Exception e) {
            e.printStackTrace();

        }
        LandingPage landingPage = new LandingPage(driver);
        Boolean result = landingPage.isFileDownloaded("C:/Users/zener/IdeaProjects/TestAutomationHorvathKlaudia2022", "profilePicture.png");
        Assertions.assertTrue(result);
    }

    @Name("getTextFromPage")
    @Tag("Functional Test")
    @DisplayName("Save text file")
    @Description("Verify whether a text can be saved from the page")
    @Test
    public void getTextFromPage() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();
        Thread.sleep(1500);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.saveTextFromPage();
        File f = new File("savetxt.txt");

        Assertions.assertTrue(f.exists());
        Assertions.assertNotEquals(0, f.length());

        //Boolean result = landingPage.isFileSaved("C:/Users/zener/IdeaProjects/TestAutomationHorvathKlaudia2022", "savetxt.txt");
        //Assertions.assertTrue(result);

    }

    @Name("EducationTest")
    @Tag("Functional Test")
    @DisplayName("Listing education entries")
    @Description("Check whether the entries in the education section are listable")
    @Test
    public void educationTest() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToResume();
        Thread.sleep(1500);

        String[] actual = landingPage.readEducationRecords();
        String[] expected = {"Master in Arts", "Master in Arts", "Master in Arts", "Master in Arts"};

        Assertions.assertArrayEquals(expected,actual);
    }


    @Name("experienceTest")
    @Tag("Functional Test")
    @DisplayName("Listing experience entries")
    @Description("Check whether the entries in the education section are listable")
    @Test
    public void experienceTest() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToResume();
        Thread.sleep(1500);
        landingPage.expButtonClick();

        String[] actual = landingPage.readExperienceRecords();
        String[] expected = {"Umbrella co.", "Aperture Science", "ACME Inc.", "LexCorp"};

        Assertions.assertArrayEquals(expected,actual);
    }
}