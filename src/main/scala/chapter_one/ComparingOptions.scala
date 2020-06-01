package chapter_one


import cats.instances.int._
import cats.instances.option._
import cats.syntax.eq._

object ComparingOptions {

  def compareWithoutSyntax(): Boolean = {
      // we have to give None a type because None can be of any Option[A]
    Option(1) =!= (None: Option[Int])
  }

  def compare(): Boolean = {
    import cats.syntax.option._
    1.some =!= none[Int]
  }

}
