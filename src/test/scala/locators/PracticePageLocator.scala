package locators

import org.openqa.selenium.{By, WebElement}

object PracticePageLocator {


  val Username1: By = By.cssSelector("input[name='firstname']")
  val Lastname1:By= By.id("lastName")


 //def experienceRadio(yearIndex: Int): By = By.id(s"exp-$yearIndex")

  //val dateField = By.id("datepicker")
    //def gender(gender: String): By = By.xpath(s"//input[@name='gender' and @value='$gender']")

  //val GenderMale:By=By.xpath("")
  //val GenderFemale:By=By.id("//input[@id='sex-0']")
  //val YearsExper:By=By.xpath("//input[@name='exp' and @type='radio']")


 // val Password: By = By.name("password")
  val Submit:   By = By.cssSelector("input[type='submit']")

}
