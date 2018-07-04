package com.es.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;

    @FindBy(id="user_login")
    WebElement userNameBox;

    @FindBy(id="user_pass")
    WebElement passwordBox;

    @FindBy(id="wp-submit")
    WebElement loginButton;


    public void setUserName(String  userName){
        userNameBox.sendKeys(userName);

    }

    public void setPassword(String password){
        passwordBox.sendKeys(password);

    }

    public void clickSubmit(){
        loginButton.click();

    }

    public void login(String userName , String password){
        setUserName(userName);
        setPassword(password);
        clickSubmit();
    }

    public LoginPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
