package pages
import locators.PracticePageLocator.{Lastname1, Username1}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

import java.time.Duration


object PracticePage extends BasePage {

  private val cookieAcceptButton: By = By.id("ez-accept-necessary") // Update to your actual ID

  // Page Actions

  def acceptCookiesIfPresent(): Unit = {
    try {
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
      val cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(cookieAcceptButton))
      if (cookieButton.isDisplayed) {
        cookieButton.click()
        println("✅ Cookie consent accepted.")
      }
    } catch {
      case _: org.openqa.selenium.TimeoutException =>
        println("ℹ️ Cookie consent button not present.")
    }
  }

  def inputFirstname(text: String): Unit = {
    inputText(Username1, text)

  }

  def inputLastname(text: String): Unit = {
    inputText(Lastname1, text)

  }

  def selectGender(gender: String)(implicit driver: WebDriver): Unit = {
    // 1. Cookie popup varsa kapat
    try {
      val cookie = driver.findElement(By.id("ez-cookie-template"))
      if (cookie.isDisplayed) {
        val closeButton = cookie.findElement(By.cssSelector(".close-button")) // örnek selector
        closeButton.click()
      }
    } catch {
      case _: Exception => println("No cookie popup or already closed.")
    }

    // 2. Radio buton ID’ye göre element seç
    val genderElement = gender.toLowerCase match {
      case "male" => driver.findElement(By.xpath("//*[@id='sex-0']"))
      case "female" => driver.findElement(By.xpath("//*[@id='sex-1']"))
      case _ => throw new IllegalArgumentException(s"Invalid gender: $gender")
    }

    // 3. Scroll if needed
    val js = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("arguments[0].scrollIntoView(true);", genderElement)

    // 4. Click
    genderElement.click()
    println(s"Clicked on gender: $gender")
  }
}