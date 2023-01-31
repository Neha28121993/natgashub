package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utils;

import java.util.Properties;


public class MsinPage extends TestBase {
    utils ut=new utils();

    LoginPage lp=new LoginPage();

    public MsinPage(){
        PageFactory.initElements(driver,this);
    }



    @FindBy(id="MeasurementInfo")
    WebElement msin_link;

    @FindBy(xpath="//sup[contains(text(),'?')]")
    WebElement msin_tooltipmousehover;

    @FindBy(xpath="//span[@class='customToolTip']")
    WebElement msin_tooltip;

    @FindBy(xpath="//button[contains(text(),'Download Excel')]")
    WebElement msin_downloadbutton;

    @FindBy(xpath="//span[contains(text(),'(You can download maximum 5,000 records)')]")
    WebElement msin_downloadbuttonmessage;

    @FindBy(xpath="//select[@name='tblMsin_length']")
    WebElement misn_showentriesdropdwon;

    @FindBy(id="addbtn")
    public WebElement msin_saveButton;


    public void msinuiopen()
    {
        lp.login(prop.getProperty("dgoc_username"),prop.getProperty("dgoc_password"));
        msin_link.click();
    }

    public String msintooltipverify()
    {
       ut.mousehover(msin_tooltipmousehover);
      String val= msin_tooltip.getAttribute("data-original-title");
      return val;
    }

    public void downloadexcelverify() throws InterruptedException {   ut.mousehover(msin_downloadbutton);
        Thread.sleep(3000);
        msin_downloadbutton.click();
        Thread.sleep(5000);
    }

    public Boolean downloadbuttonpresent()
    {
       boolean val= msin_downloadbutton.isDisplayed();
       return val;
    }

    public String msindownloadmessageverify()
    {
        String val= msin_downloadbuttonmessage.getText();
        return val;
    }

    public void msinshowentryvalues()
    {
       ut.selectbyvalue(misn_showentriesdropdwon,"25");
    }

    public  Boolean savebuttonvisible() throws InterruptedException {
        misn_showentriesdropdwon.click();
        Thread.sleep(3000);
        msinshowentryvalues();
        Thread.sleep(2000);
        Boolean val=msin_saveButton.isDisplayed();
        return val;
        }

    public void savebuttonworking(String viewname) throws InterruptedException {
        misn_showentriesdropdwon.click();
        Thread.sleep(3000);
        msinshowentryvalues();
        Thread.sleep(2000);
       msin_saveButton.click();
       driver.findElement(By.id("name")).sendKeys(viewname);
       driver.findElement(By.id("isDefaultView")).click();
       driver.findElement(By.id("savepopupbtn"));
    }


}
