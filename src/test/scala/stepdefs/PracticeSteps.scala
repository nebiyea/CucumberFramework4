package stepdefs
import io.cucumber.scala.{EN, ScalaDsl}
import pages.PracticePage.{acceptGrayBannerCookiesIfPresent, acceptGreenBannerCookiesIfPresent, browserLaunch, inputFirstname, inputLastname, selectGender}
import testdata.PracticeData.{UserNameText1, lastnameText1}

class PracticeSteps extends ScalaDsl with EN {

  Given("""all required fields have been populated""") { () =>
    browserLaunch()
    acceptGreenBannerCookiesIfPresent()
    acceptGrayBannerCookiesIfPresent()
    inputFirstname(UserNameText1)
    inputLastname(lastnameText1)
    println(s"Username sent: $UserNameText1")
    println(s"Lastname sent: $lastnameText1")
    selectGender("female")
    Thread.sleep(5000)
  }
}
