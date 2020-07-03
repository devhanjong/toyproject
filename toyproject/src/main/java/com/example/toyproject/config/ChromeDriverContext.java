package com.example.toyproject.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChromeDriverContext {

    private WebDriver driver;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ChromeDriverContext.class);
    private static final String CHROME_DRIVER_PATH = "c:/dev/workspace-sts/chromedriver";

    @Bean
    public WebDriver getDriver() {
        return driver;
    }

    @SuppressWarnings("deprecation")
	@Bean
    public WebDriver setupChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1366,768");
        options.addArguments("--headless");
        options.setProxy(null);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStrategy", "none");

        try {
            /*
             *
             * @ params
             * option : headless
             *
             */
            driver = new ChromeDriver(capabilities);
        } catch (Exception e) {
            ((org.slf4j.Logger) logger).error("### [driver error] msg: {}, cause: {}", e.getMessage(), e.getCause());
        }

        return driver;
    }
}