package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P05_SepetimSayfasi {
    public P05_SepetimSayfasi(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='i-trash'])[1]")
    public WebElement sepettenKaldirmaButonu;

    @FindBy(xpath = "//*[text()='Sepetim (0 Ürün)']")
    public WebElement sepetteUrunKalmamasi;
}
