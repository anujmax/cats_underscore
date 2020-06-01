package chapter_one

import java.util.Date

import cats.Eq


import cats.syntax.eq._

final case class Cat(name: String, age: Int, color: String)

object ComparingCustomTypes {

  implicit val dateEq: Eq[Date] = Eq.instance[Date] {
    import cats.instances.long._
    (date1, date2) => date1.getTime === date2.getTime
  }

  implicit val catEq: Eq[Cat] = Eq.instance[Cat] {
    import cats.instances.string._
    import cats.instances.int._
    (cat1, cat2) => (cat1.age === cat2.age) && (cat1.name === cat2.name) && (cat1.color === cat2.color)
  }

  def compare(): Boolean = {
    val x = new Date()
    val y = new Date()
    x === y
  }

  def compareCats(): Boolean = {
    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")
    cat1 =!= cat2
  }

  def compareCatsOptional(): Boolean = {
    import cats.instances.option._
    val cat1 = Option(Cat("Garfield", 38, "orange and black"))
    val cat2 = Option(Cat("Garfield", 38, "orange and black"))
    cat1 === cat2
  }


}
