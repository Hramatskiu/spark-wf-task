package com.epam.spark.wf.task

object StringDivider {
  def splitStringIntoWordsArray(string: String): Array[String] = {
    string.replaceAll("\\p{Punct}", " ")
      .trim()
      .toUpperCase()
      .split("\\s+")
  }
}
