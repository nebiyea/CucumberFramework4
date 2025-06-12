package support

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object DriverManager {
  var driver: WebDriver = _

  def getDriver: WebDriver = {
    if (driver == null) {
      driver = new ChromeDriver()
      driver.manage().window().maximize()
    }
    driver
  }

  def quitDriver(): Unit = {
    if (driver != null) {
      driver.quit()
      driver = null
    }
  }
}
