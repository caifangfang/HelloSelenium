import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����FirefoxDriverʵ��
		WebDriver driver = new FirefoxDriver();
		//���е���ҳ
		driver.get("http://www.youdao.com/n3");
		//�ҵ����������Ԫ��
		WebElement queryInputElement = driver.findElement(By.id("query"));
		//����Selenium�ؼ���
		queryInputElement.sendKeys("selenium");
		//�ҵ�������ťԪ�أ����������
		WebElement submitBtnElement = driver.findElement(By.id("qb"));
		submitBtnElement.click();
		
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//�ر������
		//driver.quit();

	}

}
