/**
 * Created by jeff on 4/9/15.
 */

import scala.io.StdIn._
import scala.util.control.BreakControl

object GuessTheNumber {
  def main(args: Array[String]): Unit = {
    val range = PickARangeDialog("Pick a number range.")
    println("you picked " + range(0) + " and " + range(1))
  }

  def PickANumberDialog(message: String): Long = {
    val number = readLine(message + "\n")
    return if (number.matches("^-?\\d+(\\.\\d)?$")) number.toLong else PickANumberDialog("That is not a number.\n " + message)
  }

  def PickARangeDialog(message: String): List[Long] = {
    println(message)
    val low = PickANumberDialog("Pick a low whole number.")
    val high = PickANumberDialog("Pick a high whole number.")
    return if (low < high) List(low, high) else PickARangeDialog("Your high number is not greater than your low number.\n" + message)
  }
}
