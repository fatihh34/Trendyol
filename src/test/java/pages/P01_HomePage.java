package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P01_HomePage {
    public P01_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath ="//*[@alt='Trendyol']")
    public WebElement anasayfaTitle;


    @FindBy (xpath = "//*[@id='login']")
    public WebElement kullaniciGirisButonu;

    @FindBy (xpath = "(//*[@class='link-text'])[1]")
    public WebElement girisButonu;

    @FindBy (xpath = "//*[@class='V8wbcUhU']")
    public WebElement aramaKutusu;






    }

