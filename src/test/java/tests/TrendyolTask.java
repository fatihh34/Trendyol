package tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrendyolTask {
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;
    public static Logger logger= LogManager.getLogger(TrendyolTask.class.getName());
    @Test
    public void trendyolTask() {

        //rapor pathi icin
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

        //HTML raporunun pathi icin
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //extent rapor objelerini configure etmek icin
        extentReports = new ExtentReports();

        //raporu customize etmek icin
        extentReports.setSystemInfo("Test Environment","Test");
        extentReports.setSystemInfo("Application","Trendyol");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Hazirlayan","Fatih Izmir");
        extentHtmlReporter.config().setDocumentTitle("OPTİİM Task Raporu");
        extentHtmlReporter.config().setReportName("Fatih Izmir Task Raporu");

        //raporu projeme eklemek icin
        extentReports.attachReporter(extentHtmlReporter);

        extentTest = extentReports.createTest("Fatih Izmir Trendyol Test Raporu",
                "OPTIIM / Hakan KAYIS Tarafından Verilen Task Raporu");
        extentTest.pass("Test Basarili");

        Driver.getDriver().get(ConfigReader.getProperty("URL2"));

        P01_AnaSayfa homePage = new P01_AnaSayfa();
        P02_UyeGirisSayfasi uyeGirisSayfasi = new P02_UyeGirisSayfasi();
        P03_UrunAramaSayfasi urunAramaSayfasi= new P03_UrunAramaSayfasi();
        P04_FavorilerimSayfasi favorilerimSayfasi= new P04_FavorilerimSayfasi();
        P05_SepetimSayfasi sepetimSayfasi= new P05_SepetimSayfasi();

        Assert.assertTrue(homePage.anasayfaTitle.isDisplayed());
       extentTest.pass("Kullanici basarili bir sekilde anasayfaya girebilmistir");
       logger.info("Kullanici basarili bir sekilde anasayfaya girebilmistir");

        uyeGirisSayfasi.popup.click();
        extentTest.info("Anasayfa acildiginda ekrana gelen pop-up kapatilmistir");
        logger.info("Anasayfa acildiginda ekrana gelen pop-up kapatilmistir");

       ReusableMethods.waitFor(3);

       homePage.girisButonu.click();
       extentTest.info("kullanici anasayfada yer alan Giris Yap butonuna tiklayabilmistir");
       logger.info("kullanici anasayfada yer alan Giris Yap butonuna tiklayabilmistir");

        uyeGirisSayfasi.emailAlani.sendKeys(ConfigReader.getProperty("email"));
        extentTest.info("Kullanici Giris Yap sayfasinda yer alan e-Posta alanina mailini girebilmistir");
        logger.info("Kullanici Giris Yap sayfasinda yer alan e-Posta alanina mailini girebilmistir");

       uyeGirisSayfasi.passwordAlani.sendKeys(ConfigReader.getProperty("sifre"));
        extentTest.info("Kullanici Giris Yap sayfasinda yer alan Sifre alanina sifresini girebilmistir");
        logger.info("Kullanici Giris Yap sayfasinda yer alan Sifre alanina sifresini girebilmistir");

        uyeGirisSayfasi.mailVeSifreIleLoginOlmaButonu.click();
        extentTest.info("Kullanici e-posta ve sifresini girerek login olabilmistir");
        logger.info("Kullanici Giris Yap sayfasinda yer alan Sifre alanina sifresini girebilmistir");
        ReusableMethods.waitFor(3);

        homePage.aramaKutusu.sendKeys("samsung"+ Keys.ENTER);
        extentTest.info("Kullanici Arama Kutusuna sammsung objesini aratabilmistir");
        logger.info("Kullanici Arama Kutusuna sammsung objesini aratabilmistir");
        ReusableMethods.waitFor(4);

        urunAramaSayfasi.sarjCihazMenu.click();
        extentTest.info("Kullanici sol menuden Sarj Cihazlarini isaretleyebilmistir");
        logger.info("Kullanici sol menuden Sarj Cihazlarini isaretleyebilmistir");
        ReusableMethods.waitFor(3);

        urunAramaSayfasi.samsungCheckBox.click();
        extentTest.info("Kullanici sol menuden samsun checkBoxini isaretleyebilmistir");
        logger.info("Kullanici sol menuden samsun checkBoxini isaretleyebilmistir");

        Assert.assertTrue(urunAramaSayfasi.samsungUrunleriAratildi.isDisplayed());
        extentTest.info("Kullanici arama sonuclarindan samsung icin sonuc bulundugunu dogrulamistir");
        logger.info("Kullanici arama sonuclarindan samsung icin sonuc bulundugunu dogrulamistir");
        ReusableMethods.waitFor(3);

        ReusableMethods.jsClick(urunAramaSayfasi.aramaSayfasiBesinciUrun);
        extentTest.info("Kullanici cikan sonuclardan ustten 5. urunu tıklayabilmistir");
        logger.info("Kullanici cikan sonuclardan ustten 5. urunu tıklayabilmistir");

        String windowHandle = Driver.driver.getWindowHandle();
        ReusableMethods.switchToWindow(1);
        ReusableMethods.waitFor(30);

        urunAramaSayfasi.besinciUrununFavoriButonu.click();
        extentTest.info("Kullanici urun detayindan begen butonuna tıklayabilmistir");
        logger.info("Kullanici urun detayindan begen butonuna tıklayabilmistir");
        ReusableMethods.waitFor(3);

        urunAramaSayfasi.favoriler.click();
        extentTest.info("Kullanici begendiklerim/favorilerim butonuna tıklayabilmistir");
        logger.info("Kullanici begendiklerim/favorilerim butonuna tıklayabilmistir");
        ReusableMethods.waitFor(3);

        Assert.assertTrue(favorilerimSayfasi.begenilenUrun.isDisplayed());
        extentTest.info("Kullanici daha once begendigi urunun favorilerim sayfasında gorundugu dogrular");
        logger.info("Kullanici daha once begendigi urunun favorilerim sayfasında gorundugu dogrular");
        ReusableMethods.waitFor(3);

        ReusableMethods.jsClick(favorilerimSayfasi.sepeteEkle);
        extentTest.info("Kullanici begendigi urunu sepete ekleyebilmistir");
        logger.info("Kullanici begendigi urunu sepete ekleyebilmistir");
        ReusableMethods.waitFor(3);

        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(favorilerimSayfasi.sepetimSekmesi).perform();
        extentTest.info("Kullanici fareyi sepetim sekmesine goturebilmistir");
        logger.info("Kullanici fareyi sepetim sekmesine goturebilmistir");

        ReusableMethods.waitFor(4);
        Assert.assertTrue(favorilerimSayfasi.siparisimiTamamlaPopup.isDisplayed());
        extentTest.info("Kullanici 'siparisimi tamamla' pop-upını goruntuleyebilmistir");
        logger.info("Kullanici 'siparisimi tamamla' pop-upını goruntuleyebilmistir");

        favorilerimSayfasi.sepetimButonu.click();
        extentTest.info("Kullanici sepetim butonuna tiklayabilmistir");
        logger.info("Kullanici sepetim butonuna tiklayabilmistir");
        ReusableMethods.waitFor(3);

        sepetimSayfasi.sepettenKaldirmaButonu.click();
        extentTest.info("Kullanici 'sepetten kaldirma' butonuna tiklayabilmistir");
        logger.info("Kullanici 'sepetten kaldirma' butonuna tiklayabilmistir");
        ReusableMethods.waitFor(5);

        Assert.assertTrue(sepetimSayfasi.sepetteUrunKalmamasi.isDisplayed());
        extentTest.info("Kullanici urunun sepetten kaldırıldıgını dogrulayabilmistir");
        logger.info("Kullanici urunun sepetten kaldırıldıgını dogrulayabilmistir");

        extentTest.pass("TEST BASARIYLA GECTI");
        extentReports.flush();
        //Driver.closeDriver();

    }
}
