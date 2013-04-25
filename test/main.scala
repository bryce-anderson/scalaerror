
import Macros.annotationFinder

object Main {
  def main(args: Array[String]) {
    println("Hello world")
    // Changes to the TestClass interface without changes to this file or macro.scala will result in no annotations being found on method foo
    val methodName = annotationFinder[TestClass]
    println(methodName)
    
  }
}