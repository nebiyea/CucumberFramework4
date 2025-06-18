package utils

object ScreenCapture {

  /** Assert that an element’s visible text equals the expected string (exact match). */
  def assert(elem: String, expected: String): Unit = {
    val actual = elem.trim
    require(
      actual == expected,
      s"Assertion failed: expected '$expected', but found '$actual'"
    )
  }
}
