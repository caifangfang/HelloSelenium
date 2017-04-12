package testngproject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudAlbumDownload {
	public static WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		// open browser
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// get url
		driver.get("http://photo.163.com");
		
		// find learn more element
		WebElement learnMoreLinkElement = driver.findElement(By.partialLinkText("�˽����"));
		// check element text
		Assert.assertEquals(learnMoreLinkElement.getText(), "�˽����","�����ҳ�����˽���ఴť");		
	}
	
	@Test
	public static void cloudAlbumDownloadTest() {
		// find learn more element
		WebElement learnMoreLinkElement = driver.findElement(By.partialLinkText("�˽����"));
		
		// click button to know more about cloud album
		learnMoreLinkElement.click();
		
		// switch to new window
		SwitchWindow(driver);
		
		// System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getTitle());
		
		//check current url
		Assert.assertEquals(driver.getCurrentUrl(), "http://photo.163.com/cloudphotos/","����˽����󣬽�����������Ӵ���");
		//check current page title
		Assert.assertEquals(driver.getTitle(), "���������-Ϊɢ�����Ƭ�Ҹ���-iPhone/iPad/Android/PC��Ƭ����ͳһ��������","����˽����󣬽��������ҳ�����");
		
		// click iphone download button
		WebElement iphoneDownloadLinkElement = driver.findElement(By.id("J-iphone"));
		iphoneDownloadLinkElement.click();
		
		WebElement iphoneDownloadPageElement = driver.findElement(By.xpath("//div[@id='J-xbox-title']"));
		// check redirect div text
		Assert.assertEquals(iphoneDownloadPageElement.getText(), "iPhone������","������غ�δ����iPhone������ҳ��");		

	}

	private static void SwitchWindow(WebDriver driver) {
		//�õ���ǰ���ڵľ�� 
	    String currentWindow = driver.getWindowHandle();
	  
	    //�õ����д��ڵľ��
	    Set<String> handles = driver.getWindowHandles();
	    
	    //��������ǰ����
	    handles.remove(currentWindow);
	    
	    for(String winHandle:handles){
	        driver.switchTo().window(winHandle);
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass(){
		//quit browser
		driver.quit();
	}
}
