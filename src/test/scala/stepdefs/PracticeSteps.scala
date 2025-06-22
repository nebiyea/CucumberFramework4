package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import pages.LoginPage.{browserLaunch1, inputUserName}
import pages.PracticePage
import pages.PracticePage.acceptCookiesIfPresent
import support.DriverManager.driver
import testdata.PracticeData.{UserNameText1, lastnameText1}



class PracticeSteps extends ScalaDsl with EN{



  Given("""the user enters the name and last name on the practice form page""") { () =>
    browserLaunch1()
    acceptCookiesIfPresent()
    inputUserName(UserNameText1)
    inputUserName(lastnameText1)
    println(s"Username sent: $UserNameText1")
    println(s"Lastname sent: $lastnameText1")
    Thread.sleep(5000);
  }

  And("""the user fills in the "Gender", "Years of Experience", and "Date" page""") { () =>//
    implicit val webDriver: WebDriver = driver
    PracticePage.selectGender("male")
    PracticePage.selectGender("female")

  }

  When("""the user fills in the "Profession" and "Tool on page""") { ()=>


  }

  And("""the user selects a continent and adds a Selenium comment""") { ()=>


  }
  Then("""the form should be submitted successfully""") { () =>


  }
}
