package com.epam.spark.wf.task

import org.apache.spark.sql.SparkSession
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, Matchers}

abstract class BaseSuite extends AnyFunSuite with BeforeAndAfterEach with BeforeAndAfterAll with Matchers {
  var sparkSession: SparkSession = _

  override def beforeAll() {
    sparkSession = SparkSession
      .builder()
      .config("spark.sql.streaming.schemaInference", "true")
      .master("local")
      .getOrCreate()
  }

  override def afterAll() {
    sparkSession.stop()
  }
}
