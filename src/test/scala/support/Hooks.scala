package support
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.Before
import org.openqa.selenium.By
import support.DriverManager.driver


class Hooks extends ScalaDsl with EN {


  val options = new ChromeOptions()
  //options.addArguments("--headless=new")

  Before {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
  }


  After {
    println("Closing browser after scenario...")
    DriverManager.driver.quit()

  }
//  @Before
//  def beforeScenario(): Unit = {
//    // Popup varsa kapat
//    try {
//      val cookiePopup = driver.findElement(By.id("ez-cookie-dialog-wrapper"))
//      if (cookiePopup.isDisplayed) {
//        val closeButton = driver.findElement(By.id("ez-accept-all")) // Buton ID'si doğru olmalı
//        closeButton.click()
//        println("Cookie popup kapatıldı.")
//      }
//    } catch {
//      case _: org.openqa.selenium.NoSuchElementException =>
//        println("Cookie popup görünmedi.")
//    }
//  }
}
