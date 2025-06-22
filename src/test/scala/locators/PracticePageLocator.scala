package locators

import org.openqa.selenium.{By, WebElement}

object PracticePageLocator {

  val Username: By = By.cssSelector("input[name='firstname']")
  val Lastname: By = By.cssSelector("input[name='lastname']")

  val genderMale: By = By.xpath("//*[@id='sex-0']")
  val genderFemale: By = By.xpath("//*[@id='sex-1']")

  val yearExperience: By=By.cssSelector("input[id='exp-0']")

}
