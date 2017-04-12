package testngproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAlbumAlert {
	public static WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		// open browser
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// get url
		driver.get("http://photo.163.com");
		
		//timeout for each
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='http://blog.163.com/newpage/ursweb/tmpl2/loginurs.html']")));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
				
		//get username input element
		WebElement userNameElement = driver.findElement(By.name("email"));
		//text username
		userNameElement.sendKeys("xiangyuantest2@163.com");
				
		//get password input element
		WebElement pwdElement = driver.findElement(By.name("password"));
		//text correct password
		pwdElement.sendKeys("xiangyuan163");
				
		//get login button element
		WebElement loginElement = driver.findElement(By.id("dologin"));
		loginElement.click();
		
		//wait for 15 seconds, may have to text verify code
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//something unknown yet
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
		//find my album element
		WebElement albumElement = driver.findElement(By.className("album"));
		
		// check element text
		Assert.assertEquals(albumElement.getText(), "�����ҵ����","��¼��δ��ʾ�����ҵ����");
		//click element
		albumElement.click();
		
		//check current url
		Assert.assertEquals(driver.getCurrentUrl(), "http://photo.163.com/xiangyuantest2/#m=0&p=1","��¼�󣬽����ҵ�������Ӵ���");
		//check current page title
		Assert.assertEquals(driver.getTitle(), "xiangyuantest2���������_xiangyuantest2���������Ƭ�洢_�������","��¼�󣬽����ҵ�������");
	}
	
	@Test
	public static void createAlbumAlertTest() {				
		//find create album element,click element
		WebElement createAlbumElement = driver.findElement(By.linkText("�������"));
		createAlbumElement.click();
		
		//wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//find confirm button element
		WebElement confirmElement = driver.findElement(By.xpath("//button[@name='fm-a']"));
		//click confirm button
		confirmElement.click();
		
		//switch to alert window
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "������������ƣ�","δ��д������Ƶ��������������Ϣ����");
		
		//close alert window
		alert.accept();
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass(){
		//quit browser
		driver.quit();
	}

}
