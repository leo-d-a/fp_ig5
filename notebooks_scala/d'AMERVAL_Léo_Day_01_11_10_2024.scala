// Databricks notebook source
println("Hello world!")

// COMMAND ----------

var x = 10

// COMMAND ----------

val y = 20

// COMMAND ----------

// MAGIC %md
// MAGIC Cannot change a value of val because it's an **immutable variable** 

// COMMAND ----------

//y = 5
//println(y)
//Will fail

// COMMAND ----------

// MAGIC %md
// MAGIC # Functions

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(562,1599)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addTwoNumbers = addSimple(562,1599)

// COMMAND ----------

// MAGIC %md
// MAGIC # Higher-Order Functions

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n*10
  f(x)
}

// COMMAND ----------

// MAGIC %md
// MAGIC ## Function Literals

// COMMAND ----------

val higherOrderFunctionTest1 = encode(10, (x: Int) => {x+100})

// COMMAND ----------

// MAGIC %md
// MAGIC In this case `(x: Int) => {x+100}` is the unnamed/anonymous function

// COMMAND ----------

val higherOrderFunctionTest2 = encode(5, (x: Int) => {x+100})

// COMMAND ----------

val higherOrderFunctionTest3 = encode(5, x => x + 100)

// COMMAND ----------

val higherOrderFunctionTest3 = encode(5, _ + 100)

// COMMAND ----------



// COMMAND ----------

// MAGIC %md
// MAGIC # Classes

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val vision = new Car("Hyundai", "Vision N74", "Grey")
val porsche991 = new Car("Porsche", "991 992 Carrera 4S", "Guard's Red")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Singleton
// MAGIC We can define an object instead of a class if we want to define a singleton

// COMMAND ----------

// MAGIC %md
// MAGIC ## Case classes

// COMMAND ----------

case class Message(from : String, to: String, content: String)
//eqivalent of
//class Message(val from : String, val to: String, val content: String)

// COMMAND ----------

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Pattern Matching

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10,20,"+")
val product = f(10,20,"*")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Homework

// COMMAND ----------

def square(x: Int): Int = {
  val value = x * x
  return value
}
val g = square(5)
