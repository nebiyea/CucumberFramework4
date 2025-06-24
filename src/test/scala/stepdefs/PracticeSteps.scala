package stepdefs
import io.cucumber.scala.{EN, ScalaDsl}
import pages.PracticePage.{acceptGrayBannerCookiesIfPresent, acceptGreenBannerCookiesIfPresent, browserLaunch, enterTodayDate, inputFirstname, inputLastname, selectCommand, selectCountry, selectGender, selectProfession, selectTool, selectYearsExperience,uploadFile}
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
    selectCountry("Europe")
    selectCommand()
    uploadFile()

  }

  When ("""the submit button is selected""") { () =>
    //submit()

  }
}
