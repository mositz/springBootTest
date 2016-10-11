package org.test.testng;
import org.testng.annotations.Test;
public class TestBase {
	
	 @Test(dataProvider="loginProvider",dataProviderClass=LoginDataProvider.class)
//	    public  void loginRight(Map<?, ?> param) throws InterruptedException{
//
//	        baiduPage.clickLogin();
//	        loginPage.login_Right((String)param.get("username"), (String)param.get("password"));
//	        
//	        System.out.println();
//	    }
	 
	 public void login(String loginName,String passWord){
		 
		 System.out.println("lallallala"+loginName);
		 System.out.println("lallallala"+passWord);
	 }

}
