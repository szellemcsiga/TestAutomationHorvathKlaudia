import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Blog extends PageBase {


    public Blog(WebDriver drv) {
        super(drv);
    }

    private final By nextLink = By.xpath("//a[@rel='next']");

    private final By tableRowVisible = By.xpath("//img[@alt=\"post-image\"]");

    public int numberOfRows() {
        int num = 0;

        List<WebElement> rows = driver.findElements(tableRowVisible);
        num = rows.size();

        return num;
    }


    public boolean isLastPage() {
        try {
            driver.findElement(nextLink);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void clickNext () {
        if (!isLastPage()) {
            driver.findElement(nextLink).click();
        }
    }

}
