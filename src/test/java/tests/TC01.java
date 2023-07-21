package tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_UyeGirisSayfasi;
import pages.P03_UrunAramaSayfasi;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.RaporlamaUtil;
import utilities.ReusableMethods;

public class TC01 {
    private final String testName = "US01 || TC01-HepsiBurada sitesi açılıp anasayfanin acildigi onaylanacak ";
    private final String description = "Adres alanina dogru URL girilerek anasayfaya gidilmeli ve dogrulanmali";
    private final String raporMesaji = "Kullanıcı başarılı bir şekilde anasayfaya girmistir";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void successfuCustomerRegisterationl() {
        Driver.getDriver().get(ConfigReader.getProperty("URL2"));

        P01_HomePage homePage = new P01_HomePage();
        P02_UyeGirisSayfasi uyeGirisSayfasi = new P02_UyeGirisSayfasi();
        P03_UrunAramaSayfasi urunAramaSayfasi= new P03_UrunAramaSayfasi();

        Assert.assertTrue(homePage.anasayfaTitle.isDisplayed());
       RaporlamaUtil.extentTestInfo("Kullanıcı başarılı bir şekilde anasayfaya girmistir");

        uyeGirisSayfasi.popup.click();

       ReusableMethods.waitFor(3);

       homePage.girisButonu.click();
       //ReusableMethods.waitFor(3);

        uyeGirisSayfasi.emailAlani.sendKeys(ConfigReader.getProperty("email"));
        //ReusableMethods.waitFor(3);

       uyeGirisSayfasi.passwordAlani.sendKeys(ConfigReader.getProperty("sifre"));

        uyeGirisSayfasi.sifreyleGirisButonu.click();
        ReusableMethods.waitFor(3);

        homePage.aramaKutusu.sendKeys("samsung"+ Keys.ENTER);

        urunAramaSayfasi.sarjCihazMenu.click();
        ReusableMethods.waitFor(3);

        urunAramaSayfasi.samsungCheckBox.click();

        Assert.assertTrue(urunAramaSayfasi.samsungUrunleriAratildi.isDisplayed());
        ReusableMethods.waitFor(3);

        ReusableMethods.jsClick(urunAramaSayfasi.aramaSayfasiBesinciUrun);

        ReusableMethods.waitFor(8);

//        String windowHandle = Driver.driver.getWindowHandle();
//        System.out.println(windowHandle);
//        Driver.driver.switchTo().window(windowHandle);
//        ReusableMethods.waitFor(3);

       // Driver.driver.switchTo().newWindow(urunAramaSayfasi.besinciUrununFavoriButonu.click()

        urunAramaSayfasi.besinciUrununFavoriButonu.click();


        ReusableMethods.waitFor(3);
        //Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
