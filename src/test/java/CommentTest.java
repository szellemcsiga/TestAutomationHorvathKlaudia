import jdk.jfr.Description;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CommentTest extends TestPageBase {

    @Name("leaveComment")
    @Tag("Functional Test")
    @DisplayName("Leave a Comment")
    @Description("Verify the comment page is working properly.")
    @Test
    public void leaveComment() throws InterruptedException {
        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickContactMe();
        Comment comment = new Comment(driver);
        Thread.sleep(1500);
        comment.fillName("Kis Aranka");
        comment.fillEmail("kisaran@freemail.hu");
        comment.fillMessage("\"Don't worry about a thing,\n" +
                "'Cause every little thing gonna be all right.\n" +
                "Singin': \"Don't worry about a thing,\n" +
                "'Cause every little thing gonna be all right! \"\n" +
                "\n" +
                "Rise up this mornin',\n" +
                "Smile with the risin' sun,\n" +
                "Three little birds\n" +
                "Each by my doorstep\n" +
                "Singin' sweet songs\n" +
                "Of melodies pure and true,\n" +
                "Sayin', (\"This is my message to you-ou-ou: \")");
        comment.AgreeTerms();
        comment.SendMessage();
        String expected = "Comment sent";
        String actual = comment.getResult();

        Assertions.assertEquals(expected, actual);
    }

}


