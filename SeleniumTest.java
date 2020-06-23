import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dhuphim on 3/12/20.
 */


//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dhuphim/Downloads/chromedriver");
        // declaration and instantiation of objects/variables
        WebDriver driver = new ChromeDriver();
        driver.get("https://login-intranet.isso.intranet.db.com/websso/sso_Logon.sso?CTAuthMode=BASIC&ct_orig_uri=https%3A%2F%2Flogin-intranet.isso.intranet.db.com%3A443%2Fwebsso%2Fsso_FallThrough.sso&requesting_slave=https%3A%2F%2Fuat.mydb-upgrade.global.intranet.db.com%2Fnews%3FstreamSource%3Dpublication%26streamID%3D1034227&viaFT=false");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("user"));
        searchBox.sendKeys("himanshu.dhuper@db.com");
        WebElement searchBox2 = driver.findElement(By.name("password"));
        searchBox2.sendKeys("Lob@Db12345");
        searchBox.submit();
        searchBox2.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();

    }

}
