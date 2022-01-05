package bring_it_on.test;

import bring_it_on.page.PasteBinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinTests {


    private static final  String PASTE_NAME = "how to gain dominance among developers";
    private static final String PASTE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

   private WebDriver driver;

   @BeforeMethod(alwaysRun = true)
   public void browserSetup() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
   }

   @Test
   public void createdPasteBinPageTitleTest() {
       String pageTitle = new PasteBinHomePage(driver)
               .openPage()
               .createPaste(PASTE_TEXT, "Bash", "10 Minutes", PASTE_NAME)
               .pageTitle();
       Assert.assertEquals(pageTitle, PASTE_NAME);
   }

   @Test
   public void pasteBinSyntaxHighlightingTest() {
       String syntaxHighlighting = new PasteBinHomePage(driver)
               .openPage()
               .createPaste(PASTE_TEXT, "Bash", "10 Minutes", PASTE_NAME)
               .syntaxHighlightingLanguage();
       Assert.assertEquals(syntaxHighlighting, "Bash");
   }

   @Test
   public void pasteBinTextTest() {
       String pasteText = new PasteBinHomePage(driver)
               .openPage()
               .createPaste(PASTE_TEXT, "Bash", "10 Minutes", PASTE_NAME)
               .pasteText();
       Assert.assertEquals(pasteText, PASTE_TEXT);
   }

   @AfterMethod(alwaysRun = true)
   public void browserTearDown() {
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       driver.quit();
       driver = null;
   }

}
