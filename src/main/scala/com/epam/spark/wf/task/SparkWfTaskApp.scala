package com.epam.spark.wf.task

import com.epam.spark.wf.task.AppConstant._
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkWfTaskApp {
  def main(args: Array[String]): Unit = {
    println(args)someerrorme
    val params = getParamMap(args)

    println(params)

    val sc = new SparkContext(new SparkConf().setMaster(params(SPARK_MASTER_SETUP))
      .setAppName(params(BATCH_APP_NAME))
      .set("spark.sql.streaming.schemaInference", "true"))

    performWordCount(sc.textFile(params(INPUT_PATH)))
      .saveAsTextFile(params(OUTPUT_PATH))
  }

  private def performWordCount(lineRDD: RDD[String]): RDD[(String, Int)] = {
    lineRDD.flatMap(StringDivider.splitStringIntoWordsArray)
      .map((_, 1))
      .reduceByKey(_ + _)
  }

  private def getParamMap(args: Array[String]): Map[String, String] = {
    args
      .map(_.split("="))
      .map(t => (t(0), t(1)))
      .toMap[String, String]
  }
}
