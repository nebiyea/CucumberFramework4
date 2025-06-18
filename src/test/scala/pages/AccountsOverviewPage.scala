package pages

import pages.BasePage.driver
import utils.ConfigReader


object AccountOverviewPage {
  // — Launching the test URL —
  def verifyHeader(): Unit = {

    val testUrl = ConfigReader.get("test.url")
    driver.get(testUrl)
  }

}

