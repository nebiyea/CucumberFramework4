package pages
import locators.PracticePageLocator.{Lastname, Profession, Tools, Username, cookieGrayBannerAcceptButton, cookieGreenBannerAcceptButton, dateInput, genderFemale, genderMale, yearsExperience}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import utils.WaitUtils
import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalDate}



object PracticePage extends BasePage {

  def acceptGreenBannerCookiesIfPresent(): Unit = {
    try {
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
      val cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(cookieGreenBannerAcceptButton))
      if (cookieButton.isDisplayed) {
        cookieButton.click()
        println(" Cookie consent accepted.")
      }
    } catch {
      case _: org.openqa.selenium.TimeoutException =>
        println("ℹ Cookie consent button not present.")
    }
  }

  def acceptGrayBannerCookiesIfPresent(): Unit = {
    try {
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
      val cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(cookieGrayBannerAcceptButton))
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
        clickOn(genderMale)
      case "female" =>
        WaitUtils.waitForElementVisible(driver, driver.findElement(genderFemale), 10)
        clickOn(genderFemale)
      case _ =>
        println(" invalid gender. Please choose 'male' or 'female'.")
        return
    }
    println(s" $gender Female selected.")
  }

  def selectYearsExperience(): Unit = {
    clickOn(yearsExperience)
    println(s" Experience year 6 ")

  }
  def enterTodayDate(): Unit = {
    val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val input = driver.findElement(dateInput)
    input.clear()
    input.sendKeys(today)
    println(s" Today's date entered: $today")
}
def selectProfession(): Unit ={
  clickOn(Profession)
  println("Profession Autmotion Tester")

}
 def selectTool(): Unit ={
   clickOn(Tools)
   println("Selenium Webdriver")
 }

}