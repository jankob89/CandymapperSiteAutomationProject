package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {
		throw new IllegalStateException("DriverManager class");
	}

	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	public static void removeDriver() {
		tlDriver.remove();
	}
}
