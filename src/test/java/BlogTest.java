import jdk.jfr.Description;
import jdk.jfr.Name;
import org.codehaus.plexus.languages.java.jpms.MainClassModuleNameExtractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class BlogTest extends TestPageBase {


    @Name("goToBlog")
    @Tag("Functional Test")
    @DisplayName("Pagination Test")
    @Description("Verify the pagination, and check the number of blog entries.")
    @Test
    public void goToBlog() throws InterruptedException {

        Main main = new Main(driver);
        main.SignInTest();
        main.loginTest();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToBlog();
        Thread.sleep(3000);
        landingPage.seeAllPosts();
        Thread.sleep(3000);
        Blog blog = new Blog(driver);
        // blog.clickNext();
        int actual = 0;

        while (true) {
            actual += blog.numberOfRows();

            if (blog.isLastPage()) {
                break;
            }
            blog.clickNext();
        }
        Assertions.assertEquals(9, actual);
    }
}
