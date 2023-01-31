package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends TestBase{
   public LoginPage()
   {
       PageFactory.initElements(driver,this);
   }

   @FindBy(id="Email")
  WebElement login_Username;

   @FindBy(id="Password")
    WebElement login_Password;

   @FindBy(xpath="//input[@type='submit']")
    WebElement login_Loginbutton;

   @FindBy(xpath="//ins[@class='iCheck-helper']")
    WebElement login_Remembermecheckbox;

   @FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
    WebElement login_ForgotPassLink;

   @FindBy(xpath="//div[@class='validation-summary-errors text-danger']//ul//li")
   String login_errormessage;

   @FindBy(xpath="//ins[@class='iCheck-helper']")
   WebElement login_remembermecheckbox;

   public void login(String name,String Pass)
   {
       login_Username.sendKeys(name);
       login_Password.sendKeys(Pass);
       login_Loginbutton.click();
   }

   public String login_errormessage()
   {
       String errormessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors text-danger']//ul//li")).getText();
       return errormessage;
   }

    public void login_checkbox()
    {
        login_remembermecheckbox.click();
    }






}
