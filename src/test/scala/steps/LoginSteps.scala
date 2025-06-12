package steps

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import support.DriverManager

class LoginSteps extends ScalaDsl with EN {

  Given("I open the login page") { () =>
    DriverManager.getDriver.get("https://example.com/login")
  }

  Then("I should see the login form") { () =>
    val loginForm = DriverManager.getDriver.findElement(By.id("loginForm"))
    assert(loginForm.isDisplayed)
  }
}
