package utils

import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.nio.file.{Files, Paths}
import java.text.SimpleDateFormat
import java.util.Date

object ScreenCapture {

  def takeScreenshot(driver: WebDriver, folderPath: String, fileName: String): File = {
    val timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date())
    val screenshotDir = Paths.get(folderPath)
    if (!Files.exists(screenshotDir)) Files.createDirectories(screenshotDir)

    val srcFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    val screenshotFile = screenshotDir.resolve(s"${fileName}_$timestamp.png").toFile

    FileHandler.copy(srcFile, screenshotFile)
    screenshotFile
  }

}