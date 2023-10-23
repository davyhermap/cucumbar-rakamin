package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class saucedemo {
    WebDriver driver;
    @Given("User dalam halaman login SauceDemo")
    public void userDalamHalamanLoginSauceDemo() {
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("User memasukan usernam dan password yang terdaftar")
    public void userMemasukanUsernamDanPasswordYangTerdaftar() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("secret_sauce");
    }
    @When("User menekan tombol login")
    public void userMenekanTombolLogin() {
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();
    }
    @Then("User berhasil login di halaman katalog produk")
    public void UserBerhasilLoginDiHalamanKatalogProduk() {
        WebElement assertion = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        assertion.isDisplayed();

        driver.close();
    }

    @When("User enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("xixixi");
    }

    @Then("User melihat pesan error")
    public void userMelihatPesanError() {
        WebElement assertion = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
        assertion.isDisplayed();

        driver.close();
    }

    @Given("User telah login kedalam website SauceDemo")
    public void UserTelahLoginKedalamWebsiteSauceDemo() {

        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("secret_sauce");

        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();

        WebElement assertion = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        assertion.isDisplayed();

    }

    @When("User menambahkan beberapa item kedalam cart")
    public void userAddsMultipleItemsToTheCart() {
        WebElement item1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        item1.click();

        WebElement item2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        item2.click();

    }

    @Then("Keranjang user harus memiliki item yang di pilih")
    public void keranjangUserHarusMemilikiItemYangDiPilih() {
        WebElement cart = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
        cart.click();

        WebElement assert1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]"));
        assert1.isDisplayed();

        WebElement assert2 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/a[1]/div[1]"));
        assert2.isDisplayed();

        driver.close();
    }

    @When("User melakukan proses checkout")
    public void userMelakukanProsesCheckout() {
        WebElement item1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        item1.click();

        WebElement item2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        item2.click();

        WebElement cart = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
        cart.click();

        WebElement assert1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]"));
        assert1.isDisplayed();

        WebElement assert2 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/a[1]/div[1]"));
        assert2.isDisplayed();

        WebElement Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        Checkout.click();
    }

    @And("User memasukkan alamat pengiriman")
    public void userMemasukkanAlamatPengiriman() {
        WebElement firstname = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstname.sendKeys("Muhammad");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastname.sendKeys("Fadly");

        WebElement zip = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zip.sendKeys("16922");

        WebElement button = driver.findElement(By.xpath("//input[@id='continue']"));
        button.click();

    }

    @And("User completes the purchase")
    public void userCompletesThePurchase() {
        WebElement overview = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]"));
        overview.isDisplayed();

        WebElement finish = driver.findElement(By.xpath("//button[@id='finish']"));
        finish.click();

    }

    @Then("User harus melihat notifikasi order pesanan berhasil")
    public void userHarusMelihatNotifikasiOrderPesananBerhasil() {
        WebElement notification = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        notification.isDisplayed();

        driver.close();
    }

}