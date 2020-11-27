import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class LogOutTest {
    // Sam Justé - r0797248

    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";


    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sam_2\\Documents\\Chrome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_logout_works(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.setUseridField("admin");
        homePage.setPasswordField("k");
        homePage.clickLoginButton();

        assertTrue(homePage.findLogoutButton());
        homePage.clickLogoutButton();
        assertTrue(homePage.findLogInButton());


    }

    @Test
    public void test_cannot_logout_when_not_logged_in(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        boolean works = false;


        assertTrue(homePage.findLogInButton());
        assertFalse(homePage.findLogoutButton());

        if(homePage.findLogoutButton()){
            homePage.clickLogoutButton();
        } else {
            works = true;
        }
        assertTrue(works);

    }

}
