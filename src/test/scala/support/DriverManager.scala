package support
import org.openqa.selenium.WebDriver



object DriverManager {


  var driver: WebDriver = _

  def quitDriver(): Unit = {
    if (driver != null) {
      driver.quit()
      driver = null
    }
  }
}