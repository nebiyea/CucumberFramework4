package stepdefs
import io.cucumber.scala.{EN, ScalaDsl}
import pages.PracticePage.{acceptGrayBannerCookiesIfPresent, acceptGreenBannerCookiesIfPresent, browserLaunch, enterTodayDate, inputFirstname, inputLastname, selectGender, selectProfession, selectTool, selectYearsExperience}
import testdata.PracticeData.{UserNameText, lastnameText}


class PracticeSteps extends ScalaDsl with EN {

  
  Given("""the practice page has been opened""") { () =>
    browserLaunch()
    acceptGreenBannerCookiesIfPresent()
    acceptGrayBannerCookiesIfPresent()
  }

  Given("""all required fields have been populated""") { () =>
    inputFirstname(UserNameText)
    inputLastname(lastnameText)
    println(s"Username sent: $UserNameText")
    println(s"Lastname sent: $lastnameText")
    selectGender("female")
    selectYearsExperience()
    enterTodayDate()
    selectProfession()
    selectTool()

    Thread.sleep(50000)

  }
  When ("""the submit button is selected"""){ () =>


  }
}
