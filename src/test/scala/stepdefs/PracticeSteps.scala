package stepdefs
import io.cucumber.scala.{EN, ScalaDsl}
import pages.PracticePage.{acceptGrayBannerCookiesIfPresent, acceptGreenBannerCookiesIfPresent, browserLaunch, inputFirstname, inputLastname, selectGender}
import testdata.PracticeData.{UserNameText1, lastnameText1}

class PracticeSteps extends ScalaDsl with EN {

  Given("""the practice page has been opened""") { () =>
    browserLaunch()
    acceptGreenBannerCookiesIfPresent()
    acceptGrayBannerCookiesIfPresent()
  }

  Given("""all required fields have been populated""") { () =>
    inputFirstname(UserNameText1)
    inputLastname(lastnameText1)
    println(s"Username sent: $UserNameText1")
    println(s"Lastname sent: $lastnameText1")
    selectGender("female")
  }
}
