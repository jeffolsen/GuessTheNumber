/**
 * Created by jeff on 4/9/15.
 */

import scala.io.StdIn._
import scala.util.control.BreakControl

object GuessTheNumber {
  def main(args: Array[String]): Unit = {

    val range = PickARange()
    println("you picked " + range(0) + " and " + range(1))
  }

  def PickANumber(message: String): Int = {
    val number = readLine(message + "\n")

    if (number.matches("^-?\\d+(\\.\\d)?$"))
    {
      return number.toInt
    }
    else
    {
      println("that is not a number")
      return PickANumber(message)
    }
  }

  def PickARange(): List[Int] = {
    val low = PickANumber("Pick a low whole number")
    val high = PickANumber("Pick a high whole number")

    if (low < high)
    {
      return List(low, high)
    }
    else
    {
      println("Your high number is not greater than your low number")
      return PickARange()
    }
  }
}
