// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
Logger.getLogger("org").setLevel(Level.ERROR)

val programStartTime = System.nanoTime()

val logFile = "/FileStore/tables/README.md"
val logData = spark.read.textFile(logFile).cache()

val numSpark = logData.filter(line => line.contains("Spark")).count()
val numScala = logData.filter(line => line.contains("Scala")).count()

println(s"\nLines with word Spark: $numSpark, \nLines with word Scala: $numScala")

val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9
println(s"\nProgram execution time: $programElapsedTime seconds")
println("\n ---------- Program ****Completed**** Successfully ---------- n")

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object StackOverflowTest extends App {


    val programStartTime = System.nanoTime()

    Logger.getLogger("org").setLevel(Level.ERROR)

    val csvDataFile = "/FileStore/tables/stackoverflow.csv"

    val spark = SparkSession.builder
      .appName("Stackoverflow Application")
       .master("local[*]")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val df = spark.read
      .option("header", "false")
      .option("inferSchema", "true")
      .csv(csvDataFile)

    println(s"\nCount of records in CSV file: ${df.count()}")
    df.printSchema()
    df.show(5)


    val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9
    println(s"\nProgram execution time: $programElapsedTime seconds")
    spark.stop()

}
