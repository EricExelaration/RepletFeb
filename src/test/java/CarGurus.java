import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CarGurus {

    @Test
    public void testCarGurus() throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );
        driver.get( "https://www.cargurus.com" );

        driver.findElement( By.xpath( "//label[@data-tab-name='UsedCar']" ) ).click();
        Thread.sleep( 1000 );
        Assert.assertEquals( new Select( driver.findElement( By.id( "carPickerUsed_makerSelect" ) ) ).getFirstSelectedOption().getText(), "All Makes" );
        new Select( driver.findElement( By.id( "carPickerUsed_makerSelect" ) ) ).selectByVisibleText( "Lamborghini" );

        Assert.assertEquals( new Select( driver.findElement( By.id( "carPickerUsed_modelSelect" ) ) ).getFirstSelectedOption().getText(), "All Models" );
        Thread.sleep( 1000 );List<String> allModels = new ArrayList<>();
        for (WebElement one : new Select( driver.findElement( By.id( "carPickerUsed_modelSelect" ) ) ).getOptions()) {
            allModels.add( one.getText() );
        }
        Assert.assertEquals( allModels, List.of(  "All Models", "Aventador", "Huracan", "Urus", "400GT", "Centenario", "Countach", "Diablo", "Espada", "Gallardo", "Murcielago" ) );

        new Select( driver.findElement( By.id( "carPickerUsed_modelSelect" ) ) ).selectByVisibleText( "Gallardo" );
        driver.findElement( By.id( "dealFinderZipUsedId_dealFinderForm" ) ).clear();
        driver.findElement( By.id( "dealFinderZipUsedId_dealFinderForm" ) ).sendKeys( "22031", Keys.ENTER );

        List<WebElement> elements = driver.findElements( By.xpath( "//a[@data-cg-ft='car-blade-link'][not(contains(@href, 'FEATURED'))]" ) );
        for (WebElement one : elements) {
            Assert.assertTrue( one.getText().contains( "Lamborghini Gallardo" ) );
        }

        //driver.quit();
    }

}