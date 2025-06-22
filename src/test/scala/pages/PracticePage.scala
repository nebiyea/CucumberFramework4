package pages

import locators.PracticePageLocator.{Lastname, Username, genderFemale, genderMale, yearExperience}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import utils.WaitUtils

import java.time.Duration

object PracticePage extends BasePage {

  private val cookieAcceptButton: By = By.id("ez-accept-necessary")

  def acceptCookiesIfPresent(): Unit = {
    try {
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
      val cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(cookieAcceptButton))
      if (cookieButton.isDisplayed) {
        cookieButton.click()
        println(" Cookie consent accepted.")
      }
    } catch {
      case _: org.openqa.selenium.TimeoutException =>
        println("ℹ Cookie consent button not present.")
    }
  }

  def inputFirstname(text: String): Unit = {
    inputText(Username, text)
  }

  def inputLastname(text: String): Unit = {
    inputText(Lastname, text)
  }

  def selectGender(gender: String): Unit = {
    gender.toLowerCase match {
      case "male" =>
        WaitUtils.waitForElementVisible(driver, driver.findElement(genderMale), 10)
        driver.findElement(genderMale).click()
      case "female" =>
        WaitUtils.waitForElementVisible(driver, driver.findElement(genderFemale), 10)
        driver.findElement(genderFemale).click()
      case _ =>
        println(" invalid gender. Please choose 'male' or 'female'.")
        return
    }
    println(s" $gender gender selected.")
  }

}