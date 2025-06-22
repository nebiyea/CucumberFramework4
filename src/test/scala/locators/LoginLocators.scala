package locators

import org.openqa.selenium.By

object LoginLocators {

  // Login Page
  val Username: By = By.name("firstname")
  val Password: By = By.name("password")
  val Submit:   By = By.cssSelector("input[type='submit']")
}
