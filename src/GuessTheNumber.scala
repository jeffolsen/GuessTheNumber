/**
 * Created by jeff on 4/9/15.
 */

import scala.io.StdIn._
import scala.util._

object GuessTheNumber {
  def main(args: Array[String]): Unit = {
    val range = PickARangeDialog("Pick a number range.")
    println("you picked " + range(0) + " and " + range(1))
  }

  def PickANumberDialog(message: String): Long = {
    val number = List(readLine(message + "\n"))

    return number.find(_ => Long {
      if (_.matches("^-?\\d+(\\.\\d)?$")) {
        return if (Try(_.toLong).isSuccess) _ else PickANumberDialog("Whoa whoa, I can't count that far from zero.\n" + message)
      } else {
        return PickANumberDialog("That's not a number. " + message)
      }
    })
  }

  def PickARangeDialog(message: String): List[Long] = {
    println(message)
    val low = PickANumberDialog("Pick a low whole number.")
    val high = PickANumberDialog("Pick a high whole number.")

    return if (low < high) List(low, high) else PickARangeDialog("Your high number is not greater than your low number.\n" + message)
  }
}
