package com.epam.spark.wf.task

import org.scalatest.Matchers

class StringDividerTest extends org.scalatest.FunSuite with Matchers {
  test("splitStringIntoWordsArray should correctly split string with commas and spaces") {
    val result = StringDivider.splitStringIntoWordsArray("First, second, first, third")

    result.length should equal(4)
  }

  test("splitStringIntoWordsArray should correctly split string with end punct") {
    val result = StringDivider.splitStringIntoWordsArray("First, second???")

    result.length should equal(2)
  }
}
