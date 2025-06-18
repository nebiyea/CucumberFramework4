package utils


import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}
import java.net.URL

object RemotWebDriver extends App {
  // URL of your Selenium Grid Hub
  val gridHubUrl = new URL("http://localhost:4444/wd/hub")

  // Specify browser & platform (DesiredCapabilities)
  val capabilities = DesiredCapabilities.chrome() // or firefox(), edge(), etc.

  // Create RemoteWebDriver connected to Selenium Grid Hub
  val driver: WebDriver = new RemoteWebDriver(gridHubUrl, capabilities)

  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")

  println("Page title is: " + driver.getTitle)

  driver.quit()
}
