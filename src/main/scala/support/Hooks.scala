package support

import io.cucumber.scala.{Before, After}

class Hooks {
  @Before
  def setUp(): Unit = {
    DriverManager.getDriver
  }

  @After
  def tearDown(): Unit = {
    DriverManager.quitDriver()
  }
}
