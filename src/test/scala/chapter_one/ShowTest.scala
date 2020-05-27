package chapter_one

import org.scalatest._

class ShowTest extends FunSuite {

  test("Cats show for integer using object instance") {
    import cats.Show
    import cats.instances.int._ // this imports the Show type class Int instance
    // this method is inside companion object Show
    val showInt = Show.apply[Int]
    assert(showInt.show(123) == 123.toString)
  }


  test("Cats show for integer") {
    import cats.instances.int._ // this imports the Show type class Int instance
    import cats.syntax.show.toShow // for show interface syntax import,
    // now we do not need object to initiate this class
    // this calls implicit toShow method which takes implicit Show instance
    // IntInstances , which convert integer to string
    assert(123.show == 123.toString)
  }


  test("Cats show for Date") {

    import cats.Show
    import cats.syntax.show.toShow
    import java.util.Date
    implicit val dateShow: Show[Date] = new Show[Date] {
      override def show(date: Date): String = s"${date.getTime}ms since the epoch"
    }

    assert(new Date().show.contains("ms since the epoch"))
  }


  test("Cats show for Date using companion objects") {

    import cats.Show
    import cats.syntax.show.toShow
    import java.util.Date
    implicit val dateShow: Show[Date] = Show.show(date => s"${date.getTime}ms since the epoch")

    assert(new Date().show.contains("ms since the epoch"))
  }


}
