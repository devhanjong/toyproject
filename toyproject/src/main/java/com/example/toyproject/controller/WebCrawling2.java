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

public class WebCrawling2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/dev/Workspace-sts/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");

        ChromeDriver driver = new ChromeDriver(options);
		
		driver.get(
				"https://www.google.com/search?hl=ko&q=%EC%95%A0%EA%B2%AC%EC%A2%85%EB%A5%98&sa=X&ved=2ahUKEwiljNHhpLDqAhVvw4sBHf_XBDEQ1QIoAXoECBAQAg&biw=1387&bih=937"
				+ "");

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
		
		WebCrawling2 t = new WebCrawling2();
		List<WebElement> list = driver.findElementsByXPath("//*[@id=\"kp-wp-tab-overview\"]/div/div/div/div/div[1]/div/div/div/div/span[1]");
		

//		for (int i = 0; i < list.size(); i++) {
			WebElement el = list.get(0);
			String text = el.getText();
			System.out.println(text);
			
//			String src = el.getAttribute("");
//			System.out.println(src);
//			t.DownloadImage(src, i);
//		}
			
			List<WebElement> list1 = driver.findElementsByXPath("//*[@id=\"kp-wp-tab-overview\"]/div/div/div/div/div[2]/div/div/span[2]");
			WebElement el1 = list1.get(0);
			String text1 = el1.getText();
			System.out.println(text1);
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
