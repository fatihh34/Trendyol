package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P02_UyeGirisSayfasi {
    public P02_UyeGirisSayfasi(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement emailAlani;

    @FindBy(xpath = "//*[@id='login-password-input']")
    public WebElement passwordAlani;

    @FindBy(xpath ="//*[@class='q-primary q-fluid q-button-medium q-button submit']")
   public WebElement mailVeSifreIleLoginOlmaButonu;

    @FindBy(xpath = "//*[@class='modal-close']")
    public WebElement popup;


}
