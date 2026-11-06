
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        Locale.setDefault(Locale.ENGLISH);
        System.setProperty("user.language", "EN");

        if (threadDriver.get() == null) {

            EdgeOptions edgeOptions = new EdgeOptions();

            edgeOptions.addArguments("--disable-notifications");

            if (isRunningOnJenkins()) {
                edgeOptions.addArguments(
                        "--headless=new",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-gpu",
                        "--window-size=1400,2400"
                );
            } else {
                edgeOptions.addArguments("--start-maximized");
            }

            threadDriver.set(new EdgeDriver(edgeOptions));

            threadDriver.get().manage().timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(30));

            threadDriver.get().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));
        }

        return threadDriver.get();
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
    }

    public static void quitDriver() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }
}
