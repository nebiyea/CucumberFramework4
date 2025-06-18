package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.AccountsOverviewPage.verifyHeader
import pages.LoginPage
import pages.LoginPage.{inputPassword, inputUserName, buttonSubmit}
import testdata.Data.{passwordText, userNameText}


class LoginSteps extends ScalaDsl with EN  {

  Given("""^the user is on the OrangeHRM login page$""") { () =>
    LoginPage.browserLaunch()
  }

  When("""the user enters valid username and password""") { () =>
    inputUserName(userNameText)
    inputPassword(passwordText)
  }

  And("""the user clicks the Login button""") { () =>
    buttonSubmit()
  }

  Then("""the user should be redirected to the Dashboard""") { () =>
    verifyHeader()
  }
}