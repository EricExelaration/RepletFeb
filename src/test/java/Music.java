import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
public class Music {

     @Test
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        Faker faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );


        driver.get( "http://duotify.us-east-2.elasticbeanstalk.com/register.php" );

        // driver.findElement( By.id( "Welcome to Duotify!" ) );
        driver.findElement( By.id( "hideLogin" ) ).click();

        String username = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String email2 = faker.internet().emailAddress();
        String password = faker.internet().password();
        String password2 = faker.internet().password();


        driver.findElement( By.id( "username" ) ).sendKeys( firstName + lastName );

        driver.findElement( By.id( "firstname" ) ).sendKeys( firstName );

        driver.findElement( By.id( "lastname" ) ).sendKeys( lastName );

        driver.findElement( By.id( "email" ) ).sendKeys( email );
        driver.findElement( By.id( "email2" ) ).sendKeys( email );

        driver.findElement( By.id( "password" ) ).sendKeys( password );
        driver.findElement( By.id( "password2" ) ).sendKeys( password );

        driver.findElement( By.name( "registerButton" ) ).click();
        // driver.findElement(By.id("logout")).click();
        //  driver.quit();


        //  WebElement homePageText = driver.findElement(By.className("pageHeadingBig"));
        //String expectedHomePageText = "You Might Also Like";
        // String actualHomePageText = homePageText.getText();


        //Assert.assertEquals(actualHomePageText, expectedHomePageText);


        driver.get( "http://duotify.us-east-2.elasticbeanstalk.com/register.php" );

        driver.findElement( By.id( "loginUsername" ) ).sendKeys( firstName + lastName );

        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.name("loginButton")).click();




       driver.quit();


    }

}