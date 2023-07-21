package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P04_FavorilerimSayfasi {
   public P04_FavorilerimSayfasi(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='image-overlay-body'])[1]")
    public WebElement begenilenUrun;

    @FindBy(xpath = "//*[text()='Sepete Ekle']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//*[text()='Sepetim']")
    public WebElement sepetimSekmesi;

    @FindBy(xpath = "//*[@class='CompleteOrder']")
    public WebElement siparisimiTamamlaPopup;

    @FindBy(xpath = "(//*[text()='Sepetim'])[1]")
    public WebElement sepetimButonu;




}
