package chapter_one

import cats.Traverse
import org.scalatest._

class EqTest extends FunSuite {
  test("Cats Eq for int equality") {
    import cats.Eq
    import cats.instances.int._

    val eqInt = Eq[Int]
    assert(eqInt.eqv(123, 123))

  }
}
