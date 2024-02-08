package UDC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class RegistrationPage {
   // @Test(invocationCount = 170)

	@Test
    public static void main(String[] args)throws IOException, InterruptedException extends BaseTest{
 File src =new File("D:\\DATA.xlsx");
 FileInputStream fis =new FileInputStream(src);
 XSSFWorkbook xsf = new XSSFWorkbook(fis);
 XSSFSheet sheet = xsf.getSheetAt(1);
int rowCount =sheet.getLastRowNum();
//int colCount = sheet.getRow(0).getLastCellNum();
int i=0;
for(i =95;i<=rowCount;i++)
{
   

WebElement m=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("SignUpButton")));

//WebElement m=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSchedule"));
m.click();
Thread.sleep(5000);

//WebElement a=driver.findElement(By.id("logonIdentifier"));
WebElement email=driver.findElement(By.name("Email Address - Do This First"));
email.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
Thread.sleep(5000);
WebElement password=driver.findElement(By.name("Password"));
password.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());

WebElement signin=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/div[3]/div[4]/button"));
signin.click();
WebElement casenumber=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("ctl00$ContentPlaceHolder1$tbCaseNumber")));

//WebElement casenumber=driver.findElement(By.name("ctl00$ContentPlaceHolder1$tbCaseNumber"));
casenumber.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());

WebElement lookUp=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("ctl00$ContentPlaceHolder1$btnLookupCase")));
lookUp.click();
WebElement Proceed2=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("ctl00$ContentPlaceHolder1$btnConfirmCase")));
Proceed2.click();                       
WebElement radio1 = driver.findElement(By.xpath("/html/body/form/div[3]/div/section/div[2]/div[4]/div[1]/div[2]/label"));
radio1.click();


//if(radio1.isEnabled()) {
WebElement AttendeeName = driver.findElement(By.xpath("/html/body/form/div[3]/div/section/div[2]/div[4]/div[2]/div[1]/input"));
AttendeeName.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
WebElement Phoneno = driver.findElement(By.xpath("/html/body/form/div[3]/div/section/div[2]/div[4]/div[2]/div[4]/input"));
Phoneno.sendKeys("1234567891");
Select dropdown = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlParties")));  
dropdown.selectByIndex(1);

driver.findElement(By.xpath("/html/body/form/div[3]/div/section/div[2]/div[4]/div[3]/input[1]")).click();
driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00")).click();

driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnContinue")).click();
driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnSchedule")).click();

ArrayList<String> w1 = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(w1.get(0));

driver.navigate().refresh();
Thread.sleep(2000);

xsf.close();
System.out.print(i+"\n");
}
}
