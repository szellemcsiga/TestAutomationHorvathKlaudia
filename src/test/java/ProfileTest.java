import jdk.jfr.Description;
import jdk.jfr.Name;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProfileTest extends TestPageBase {


    @Name("editProfile")
    @Tag("Functional Test")
    @DisplayName("Edit Profile")
    @Description("Verify that the user can add data to their profile.")
    @Test
    public void editProfile() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        Profile profile = new Profile(driver);
        profile.fillName("Kiss Elemér");
        profile.fillBio("This is my bio");
        profile.fillPhoneNumber("063099988775");
        profile.saveTheProfil();

        String result = profile.getResult();
        Assert.assertEquals(result, "Profile Edited!");
    }

    @Name("editAgainProfile")
    @Tag("Functional Test")
    @DisplayName("Overwrite Profile")
    @Description("Check if it is possible to save new data in the profile.")
    @Test
    public void editAgainProfile() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();


        Profile profile = new Profile(driver);
        editProfile();
        Thread.sleep(2000);
        profile.clearForm();
        profile.fillName("Kiss Elemér");
        profile.fillBio("This is not my bio");
        profile.fillPhoneNumber("063099988775");
        profile.saveTheProfil();

        String result = profile.getResult();
        Assert.assertEquals(result, "Profile Edited!");
    }

    @Name("editMissingProfile")
    @Tag("Functional Test")
    @DisplayName("Overwrite Profile with one data")
    @Description("Checking whether it is possible to overwrite a single piece of information in the profile")
    @Test
    public void editMissingProfile() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        Profile profile = new Profile(driver);
        profile.fillName("Kiss Elemér");
        profile.fillBio("");
        profile.fillPhoneNumber("");
        profile.saveTheProfil();
        String result = profile.getResult();
        Assert.assertEquals(result, "Profile Edited!");
    }

    @Name("InvalideditProfile")
    @Tag("Functional Test")
    @DisplayName("Overwrite Profile with invalid data")
    @Description("Checking whether it is possible to overwrite profile with an invalid telephone number")
    @Test
    public void invalideditProfile() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        Profile profile = new Profile(driver);
        profile.fillName("Kiss Elemér");
        profile.fillBio("This is my bio");
        profile.fillPhoneNumber("ezegytelefonszam");
        profile.saveTheProfil();

        String result = profile.getResult();
        Assert.assertNotEquals(result, "Profile Edited!");
    }

    @Name("DeleteProfile")
    @Tag("Functional Test")
    @DisplayName("Delete Profile")
    @Description("Check whether it is possible to delete the profile.")
    @Test
    public void deleteProfile() throws InterruptedException {
        popUp popUp = new popUp(driver);
        editProfile();
        Profile profile = new Profile(driver);
        profile.deleteProfile();
        profile.sureDelete();
        String result = popUp.getOut();

        Assertions.assertEquals(result, "Terms and conditions");
    }
}
