package locators

import org.openqa.selenium.{By, WebElement}

object PracticePageLocator {

  val cookieGreenBannerAcceptButton: By = By.id("ez-accept-necessary")
  val Username: By = By.cssSelector("input[name='firstname']")
  val Lastname: By = By.cssSelector("input[name='lastname']")
  val cookieGrayBannerAcceptButton: By = By.id("cookieChoiceDismiss")
  val genderMale: By = By.xpath("//*[@id='sex-0']")
  val genderFemale: By = By.xpath("//*[@id='sex-1']")
  val yearsExperience: By=By.cssSelector("input[id='exp-5']")
  val dateInput:By=By.cssSelector("#datepicker")
  val Profession:By=By.cssSelector(" #profession-1")
  val Tools:By=By.cssSelector("#tool-2")
  val country:By=By.xpath("//*[@id=\"continents\"]")
  val selectCommands:By=By.cssSelector("#selenium_commands > option:nth-child(1)")
  val file:By=By.xpath("//*[@id=\"photo\"]")
  //val submitButtton:By= By.cssSelector("btn btn-info")






}
