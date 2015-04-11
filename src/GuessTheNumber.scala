/**
 * Created by jeff on 4/9/15.
 */

import scala.io.StdIn._
import scala.util.Try

object GuessTheNumber {
  def main(args: Array[String]): Unit = {
    val range = PickARangeDialog("Give me a number range.")
    val number = PickANumberInRangeDialog("Ok, now pick a number in the range you chose. I promise I won't peek.", range)
    val guess = BinarySearchDialog("Now Im going to guess the number in under " + Math.ceil(Math.log(range(1) - range(0)) / Math.log(2)).toInt + " tries.\nAnswer YES or NO", range)
    UserValidatorDialog(number, guess)
  }

  def PickANumberDialog(message: String): Long = {
    val number = readLine(message + "\n")

    if (number.matches("^-?\\d+$")) {
      return if (Try(number.toLong).isSuccess) number.toLong else PickANumberDialog("Whoa whoa, I can't count that far from zero. Try again.")
    } else {
      return PickANumberDialog("That is not a number. Try again.")
    }
  }

  def PickARangeDialog(message: String): List[Long] = {
    println(message)
    val low = PickANumberDialog("Pick a low whole number.")
    val high = PickANumberDialog("Pick a high whole number.")
    return if (low < high) List(low, high) else PickARangeDialog("Your high number is not greater than your low number. Try again")
  }

  def PickANumberInRangeDialog(message: String, range: List[Long]): Long = {
    val number = PickANumberDialog(message)
    return if (number > range(0) && number < range(1)) number else PickANumberDialog("The number is not in range. Try again.")
  }

  def BinarySearchDialog(message: String, range: List[Long]): Long = {
    println(range(0) + " " + range(1))
    if (range(0) == range(1)) {
      return range(0)
    }

    println(message)
    val half = Math.ceil((range(0) + range(1)) / 2).toLong
    val response = readLine("Is the number between " + range(0) + " and " + half + "?")

    if (response.toUpperCase == "YES") {
      return BinarySearchDialog("Ok.", List(range(0), half))
    } else if (response.toUpperCase == "NO") {
      return BinarySearchDialog("Ok.", List(half + 1, range(1)))
    } else {
      return BinarySearchDialog("That try didn't count. You'll have to answer YES or NO.", List(range(0), range(1)))
    }
  }

  def UserValidatorDialog(number: Long, guess: Long): Unit = {
    println("Was your number " + guess + "?")
    if (guess == number) {
      println("I win!")
    } else {
      println("You lied")
    }
  }
}
