import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


/**
 *
 */
public class WebOrder {

    @Test
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new EdgeDriver();
        Faker faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.className("button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");


        driver.findElement(By.linkText("Order")).click();


        int quantity = (int) (Math.random() * 100) + 1;
        WebElement quantityField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityField.sendKeys(Integer.toString(quantity));


        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtDiscount")).sendKeys("5");
     //  driver.findElement(By.id("ctl00_MainContent_fmwOrder_lblTotal"));
       // double expectedTotal = 100.0 * quantity * (quantity >= 10 ? 0.92 : 1.0);
      //  double actualTotal = Double.parseDouble(totalPriceField.getText().replace("$", ""));
      //  if (expectedTotal == actualTotal) {
     //       System.out.println("Total price is correct: " + actualTotal);
      //  } else {
     //       System.out.println( "Total price is incorrect: expected " + expectedTotal + ", but got " + actualTotal );
//
     //   }
        //driver.findElement(By.linkText("Calculate")).click();
        Thread.sleep( 2000 );

        String customerName = faker.name().firstName();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("customerName");


        String streetAddress = faker.address().streetAddress();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("streetAddress");

        String city = faker.address().city();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("city");

        String state = faker.address().state();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("state");


        String zipCode = faker.address().zipCode().substring(0, 5);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("zipCode");


        driver.quit();
    }
}