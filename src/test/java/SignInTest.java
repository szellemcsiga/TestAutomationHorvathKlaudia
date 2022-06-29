import jdk.jfr.Description;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SignInTest extends TestPageBase{

    //Terms and Contitions

    @Name("closeTermsAndCondtitions")
    @Tag("Functional Test")
    @DisplayName("Closing Terms and Conditions with X button")
    @Description("Verifying that the Close button is working correctly in Terms and Conditions")
    @Test
    public void closeTermsAndCondtitons() {
        Signin signin = new Signin(driver);
        signin.navigate();
        signin.closeModal();

    }

    @Name("acceptTermsAndCondtitions")
    @Tag("Functional Test")
    @DisplayName("Closing Terms and Conditions with OK button")
    @Description("Verifying that the Accept button is working correctly in Terms and Conditions")
    @Test
    public void acceptTermsAndConditions() {
        Signin signin = new Signin(driver);
        signin.navigate();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
    }

    //Sign-in Test
    @Name("SignInTest")
    @Tag("Functional Test")
    @DisplayName("Valid Sign-in Test")
    @Description("Verify if a user will be able to sing-in with a valid data.")
    @Test
    public void SignInTest() throws InterruptedException {
        Signin signin = new Signin(driver);
        signin.navigate();
        Thread.sleep(1500);
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        signin.clickOnTopRegisterButton();
        Thread.sleep(1500);
        signin.addUsername("username");
        signin.addPassword("Jelszo01");
        signin.addEmail("email@email.hu");
        signin.addDescription("nothing");
        signin.clickOnRegisterButton();
        String result = signin.getResult();
        String expected = "User registered!";

        Assertions.assertEquals(expected, result);
    }

    @Name("signInWithoutData")
    @Tag("Functional Test")
    @DisplayName("Invalid Sign-in Test with missing data")
    @Description("Verify if a user will be not able to sing-in with missing data.")
    @Test
    public void SignInWithoutData() throws InterruptedException {
        Signin signin = new Signin(driver);
        signin.navigate();
        Thread.sleep(1500);
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        signin.clickOnTopRegisterButton();
        signin.addUsername("username");
        signin.addPassword("");
        signin.addEmail("email@email.hu");
        signin.addDescription("nothing");
        signin.clickOnRegisterButton();
        String result = signin.getResult();
        String notExpected = "User registered!";

        Assertions.assertNotEquals(notExpected, result);
    }

    @Name("SignInWithWrongData")
    @Tag("Functional Test")
    @DisplayName("Invalid Sign-in Test with Wrong e-mail")
    @Description("Verify if a user not able to sing-in with a wrong e-mail address format.")
    @Test
    public void SignInWithWrongData() throws InterruptedException {

        Signin signin = new Signin(driver);
        signin.navigate();
        Thread.sleep(1500);
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        signin.clickOnTopRegisterButton();
        signin.addUsername("username");
        signin.addPassword("Jelszo01");
        signin.addEmail("emailemail.hu");
        signin.addDescription("nothing");
        signin.clickOnRegisterButton();
        String result = signin.getResult();
        String notExpected = "User registered!";

        Assertions.assertNotEquals(notExpected, result);
    }


    @Name("SignInWithDuplicateData")
    @Tag("Functional Test")
    @DisplayName("Invalid Sign-in Test with duplicate data")
    @Description("Testing the database to see if it is possible to register more than once with the same data")
    @Test
    public void SignInWithDuplicateData() throws InterruptedException {

        Signin signin = new Signin(driver);
        signin.navigate();
        Thread.sleep(1500);
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        signin.clickOnTopRegisterButton();
        signin.addUsername("username");
        signin.addPassword("Jelszo01");
        signin.addEmail("email@email.hu");
        signin.addDescription("nothing");
        signin.clearForm();
        Thread.sleep(1500);
        signin.addUsername("username");
        signin.addPassword("Jelszo01");
        signin.addEmail("email@email.hu");
        signin.addDescription("nothing");
        signin.clickOnRegisterButton();
        String result = signin.getResult();
        String expected = "User registered!";

        Assertions.assertEquals(expected, result);
    }

    @Name("textTest")
    @Tag("Functional Test")
    @DisplayName("Sign-in from a test file")
    @Description("Testing whether a text file can be used to generate serial data input")
    @Test
    public void textTest() throws InterruptedException {

        Signin signin = new Signin(driver);
        signin.navigate();
        popUp popUp = new popUp(driver);
        popUp.clickOnX();
        Thread.sleep(1500);
        signin.clickOnTopRegisterButton();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "source.txt"));

            String line = reader.readLine();
            String[] datasArray = line.split(",");

            while (line != null) {

                signin.registratefromtext(datasArray);
                line = reader.readLine();
                signin.clearForm();
                Thread.sleep(2000);
            }
            reader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        String result = signin.getResult();
        String expected = "User registered!";
        Assertions.assertEquals(expected, result);
    }
}
