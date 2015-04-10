/**
 * Created by jeff on 4/9/15.
 */

import scala.io.StdIn._
import scala.util.control.BreakControl

object GuessTheNumber {
  def main(args: Array[String]): Unit = {
    val range = PickARange("Pick a number range.")
    println("you picked " + range(0) + " and " + range(1))
  }

  def PickANumber(message: String): Int = {
    val number = readLine(message + "\n")
    return if (number.matches("^-?\\d+(\\.\\d)?$")) number.toInt else PickANumber("That is not a number.\n " + message)
  }

  def PickARange(message: String): List[Int] = {
    println(message)
    val low = PickANumber("Pick a low whole number.")
    val high = PickANumber("Pick a high whole number.")
    return if (low < high) List(low, high) else PickARange("Your high number is not greater than your low number.\n" + message)
  }
}
