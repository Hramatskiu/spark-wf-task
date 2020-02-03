package com.epam.spark.wf.task

import org.apache.spark.rdd.RDD
import org.scalatest.{Matchers, PrivateMethodTester}

class SparkWfTaskAppTest extends BaseSuite with PrivateMethodTester with Matchers {
  test("Simple spark run test") {
    val lines = sparkSession.sparkContext.parallelize(Seq(
      "Test word",
      "Split test",
      "with, different!! puncts"
    ))

    val decoratePerformWordCount = PrivateMethod[RDD[(String, Int)]]('performWordCount)

    val result = SparkWfTaskApp invokePrivate decoratePerformWordCount(lines)

    result.filter(_._1.equals("TEST")).first()._2 should equal(2)
  }
}
