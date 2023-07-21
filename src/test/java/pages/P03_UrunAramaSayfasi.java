package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P03_UrunAramaSayfasi {
    public P03_UrunAramaSayfasi(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Şarj Cihazları & Kabloları']")
    public WebElement sarjCihazMenu;

    @FindBy(xpath = "(//*[@class='chckbox'])[1]")
    public WebElement samsungCheckBox;

    @FindBy(xpath = "(//*[@class='chckbox'])[1]")
    public WebElement samsungUrunleriAratildi;

    //@FindBy(xpath = "(//*[@class='image-overlay-body'])[5]")
    //*[@class='image-overlay-body'])[5]
    //@FindBy(xpath = "(//*[@class='p-card-chldrn-cntnr card-border'])[5]")
    @FindBy(xpath = "(//*[@class='image-overlay-body'])[5]")
    public WebElement aramaSayfasiBesinciUrun;

//    @FindBy(xpath = "//*[@class='favorite-button']")
//    public WebElement besinciUrununFavoriButonu;

    @FindBy(xpath = "(//*[@class='i-heart'])[3]")
    public WebElement besinciUrununFavoriButonu;








}
