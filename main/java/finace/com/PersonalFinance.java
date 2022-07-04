package finace.com;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PersonalFinance {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/");
		
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Personal Finance"))).build().perform();
		
		driver.findElement(By.linkText("Income Tax Calculator")).click();
		
//		step2
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='tax_container' //input[@value='without'")).click();
//		
//		step3
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
//		step4
		Select s=new Select(driver.findElement(By.className("custselect")));
		s.selectByVisibleText("Stay in Non Metro city");
//		step5
		driver.findElement(By.cssSelector("[title=Next]")).click();
//		step6
		driver.findElement(By.cssSelector("[id=annual_salary]")).sendKeys("15000");
		driver.findElement(By.cssSelector("[id=other_income]")).sendKeys("15000");
		driver.findElement(By.id("income_tab_next")).click();
		
//		step7
		driver.findElement(By.id("tax_saving_investment")).sendKeys("2000");
		driver.findElement(By.cssSelector("title=Next")).click();
//		step8
		WebElement paid = driver.findElement(By.className("summary_text"));
		System.out.println(paid.getText());
//		step9
		action.moveToElement(driver.findElement(By.linkText("Mutual Funds"))).build().perform();
		driver.findElement(By.linkText("Top Ranked Funds"));
//		step10
		driver.findElement(By.className("robo_medium")).click();
		
//		step11
		Set<String> str = driver.getWindowHandles();
		Iterator <String> it = str.iterator();
		String switchScreen= it.next();
		String screen =it.next();
		driver.switchTo().window(screen);
		
		WebElement atmc= driver.findElement(By.className("amt"));
		System.out.println(atmc.getText());
	}

}
