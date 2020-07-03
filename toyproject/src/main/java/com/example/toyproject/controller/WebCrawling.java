package com.example.toyproject.controller;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebCrawling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/dev/Workspace-sts/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");

        ChromeDriver driver = new ChromeDriver(options);
		
		driver.get(
				"https://www.google.com/search?q=%ED%86%A0%EC%9D%B4+%ED%91%B8%EB%93%A4&stick=H4sIAAAAAAAAAONgFuLUz9U3SCqxzClS4gIxK_JMU7IstdSyk630kzLzc_LTK_VT8nNTi0sykxNLUlPiE_MycxNzrJKKUlNTih8xxnMLvPxxT1gqbNKak9cYA7iI1CikxsXmmleSWVIpJMPFK4VwhQaDFDcXgsuziJX3bduCN3O3KLyduOP15CUT2BgBNxaDjrYAAAA&source=lnms&tbm=isch&sa=X&ved=2ahUKEwja9_eJnLDqAhXUyYsBHY-sCQoQ_AUoAXoECBMQAw&biw=1387&bih=937");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {

			long height = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println(height);
			js.executeScript("window.scroll(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			long height2 = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println(height2);
			if (height == height2)
				break;
		}
		
		WebCrawling t = new WebCrawling();
		List<WebElement> list = driver.findElements(By.cssSelector(".rg_i"));

		for (int i = 0; i < list.size(); i++) {
			WebElement el = list.get(i);
			String src = el.getAttribute("src");
			System.out.println(src);
			t.DownloadImage(src, i);
		}
	}

	public void DownloadImage(String address, int i) {
		try {
			URL imageURL = new URL(address);
			BufferedImage saveimage = ImageIO.read(imageURL);
			ImageIO.write(saveimage, "jpg", new File("c:/dev/" + i + ".jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
