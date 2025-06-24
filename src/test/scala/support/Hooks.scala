package support
import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import utils.ScreenCapture.takeScreenshot

import java.io.File
import java.nio.file.Paths

class Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  //options.addArguments("--headless=new")

  def userScreenshotDir: String =
    Paths.get(System.getProperty("user.home"), "Documents", "Screenshots").toString

  def handleScenarioFailure(scenario: Scenario): Unit = {
    println("Scenario failed! Taking screenshot...")
    val screenshotFile: File =
      takeScreenshot(DriverManager.driver, userScreenshotDir, s"${scenario.getName}_failure")
    println(s"Saved screenshot to: ${screenshotFile.getPath} - ")
  }

  Before {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
  }

  After { scenario: Scenario =>
    if (scenario.isFailed) handleScenarioFailure(scenario)
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }
}
