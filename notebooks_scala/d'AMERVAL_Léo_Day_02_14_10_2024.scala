// Databricks notebook source
// MAGIC %md
// MAGIC # Programming Paradigms
// MAGIC - A paradigm is a way of structuring programs
// MAGIC
// MAGIC ## Main Programming Paradigms:
// MAGIC - Imperative
// MAGIC - Functional
// MAGIC - Logic
// MAGIC - Object Oriented
// MAGIC
// MAGIC ## Functional Programming (FP)
// MAGIC
// MAGIC - Functions
// MAGIC - Immutable
// MAGIC - Less code
// MAGIC - Parallelism

// COMMAND ----------

// MAGIC %md
// MAGIC ### Composable
// MAGIC - Combining simple functions to create a complex one
// MAGIC ``` 
// MAGIC f(x) = x*2 
// MAGIC g(x) = x+2
// MAGIC ```
// MAGIC - New function combining the two
// MAGIC ``` 
// MAGIC h(x) = f(g(x))
// MAGIC      =f(x+2)
// MAGIC      = (x+2)*2 
// MAGIC ```

// COMMAND ----------

//Ex of composable

def f(x: Int): Int = x * 2

def g(x: Int): Int = x + 2

def h(x: Int): Int = f(g(x))

// COMMAND ----------

// Test the h function
val input = 4
println(s"g($input) = ${g(input)}")
println(s"f(g($input)) = ${f(g(input))}")
println(s"h($input) = ${h(input)}")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Scala programmiung language
// MAGIC - Hybrid (OOP and FP)
// MAGIC - Statically typed
// MAGIC - Type-safe

// COMMAND ----------

//Statically typed ex
val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

//Type safety ex
val language: Int = "Scala"
// Won't work because the val type is Int and not String

// COMMAND ----------

//Functions type-safety
def add(x: Int, y: Int): Int = x + y
val sum = add(10,20)
println(s"Sum is $sum")

// COMMAND ----------

//Won't work
val sumTest = add(10, "20")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Operators
// MAGIC - Arithmetic
// MAGIC - Relational
// MAGIC - Logical
// MAGIC
// MAGIC *Scala does not have built-in operators* and operators are interpreted as **method** in Scala

// COMMAND ----------

val x = 10
val y = 20
val z = x + y

// COMMAND ----------

val z = x.+ (y)

// COMMAND ----------

val z1 = x.*(y)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Traits
// MAGIC - **trait** is a way to define interfaces in Scala
// MAGIC ### How they differ from Java interfaces
// MAGIC - In Scala we can both implement methods signatures and concrete method implementation 

// COMMAND ----------

trait Shape {
  def area(): Int
}

//The 'Shape' trait defines an abstract method that a class that extends it must implement
class Square(length: Int) extends Shape {
  def area = length * length
}

//Another exemple
class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}

val square = new Square(10)
val area = square.area

// COMMAND ----------

// MAGIC %md
// MAGIC ### Tuples
// MAGIC - A tuple is a container for two or more elements of different types
// MAGIC - They are immutable

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "Scout", true)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2
val third = threeElements._3

// COMMAND ----------

// MAGIC %md
// MAGIC ### Collections
// MAGIC - Is also a container data structure, it conatins 0 or multiple elements
// MAGIC - 3 categories
// MAGIC     - Sequences
// MAGIC         - Array
// MAGIC         - List
// MAGIC         - Vector
// MAGIC     - Sets
// MAGIC     - Maps

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sequences

// COMMAND ----------

val arr = Array(10,20,30,40)

// COMMAND ----------

arr(0) = 50

// COMMAND ----------

val first = arr(0)

// COMMAND ----------

// MAGIC %md
// MAGIC ### List

// COMMAND ----------

val xs = List(10,20,30,40)

// COMMAND ----------

val ys = (1 to 100).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

zs.tail

// COMMAND ----------

zs.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Vectors

// COMMAND ----------

val v1 = Vector(0,10,20,30,40)

// COMMAND ----------

val v2 = v1 :+50

// COMMAND ----------

val v3 = v2 :+60

// COMMAND ----------

val v4 = v3(4)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sets

// COMMAND ----------

val KC = Set("Cabochard", "Saken", "Caliste")

// COMMAND ----------

KC.contains("Saken")

// COMMAND ----------

KC.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Map

// COMMAND ----------

val tR = Map("Karmine Corp" -> "GOAT", "Vita" -> "HAH")

// COMMAND ----------

tR("Karmine Corp")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Higher-Order Methods on Collection Classes
// MAGIC - map
// MAGIC - flatmap
// MAGIC - filter
// MAGIC - foreach
// MAGIC - reduce

// COMMAND ----------

// MAGIC %md
// MAGIC #### map

// COMMAND ----------

val myList = List(1,2,3,4)

// COMMAND ----------

val myAnotherList = myList.map(_ *10.0)

// COMMAND ----------

// MAGIC %md
// MAGIC #### flatmap

// COMMAND ----------

val line = "Scala is fun"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map{_.toList}

// COMMAND ----------

val arrayOfChars = words.flatMap{_.toList}

// COMMAND ----------

// MAGIC %md
// MAGIC #### filter

// COMMAND ----------

val myNewList = (1 to 100).toList

// COMMAND ----------

val even = myNewList.filter(_%2 == 0)

// COMMAND ----------

// MAGIC %md
// MAGIC #### foreach

// COMMAND ----------

val words = "Scala is fun".split(" ")

// COMMAND ----------

words.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC #### reduce

// COMMAND ----------

val reduceList = List(2, 4, 6, 8, 10)

// COMMAND ----------

val sum = reduceList.reduce{(x, y) => x + y}

// COMMAND ----------

val sum = reduceList.reduce{(x, y) => x * y}

// COMMAND ----------

// MAGIC %md
// MAGIC
