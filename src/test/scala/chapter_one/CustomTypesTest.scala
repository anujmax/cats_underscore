package chapter_one

import org.scalatest._

class CustomTypesTest extends FunSuite {

  test("Cats Eq for Custom Types") {
    assert(ComparingCustomTypes.compare())
  }

  test("Cats Eq for Cat Types") {
    assert(ComparingCustomTypes.compareCats())
    assert(ComparingCustomTypes.compareCatsOptional())
  }

}
