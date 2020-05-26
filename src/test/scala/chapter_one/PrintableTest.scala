package chapter_one

import chapter_one.PrintableInstances._
import org.scalatest._

class PrintableTest extends FunSuite {

  case class Cat(name: String, age: Int, color: String)

  object NewPrintableInstances {
    implicit val printableCat: Printable[Cat] = new Printable[Cat] {
      override def format(value: Cat): String = f"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat"
    }
  }


  test("Cat able to print using Type class instance and Printable Object") {
    import NewPrintableInstances._
    val cat = Cat("whiskers", 5, "black")
    println(cat)
    assert(Printable.format(cat) == "whiskers is a 5 year-old black cat")
  }

  test("Cat able to print using Type class instance and Printable syntax") {
    import PrintableSyntax._
    import NewPrintableInstances._
    val cat = Cat("whiskers", 5, "black")
    cat.print
    assert(cat.format == "whiskers is a 5 year-old black cat")
  }


}

