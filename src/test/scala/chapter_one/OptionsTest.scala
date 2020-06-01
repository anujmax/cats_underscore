package chapter_one
import org.scalatest._

class OptionsTest extends FunSuite {

  test("Cats Eq for Options") {
    assert(ComparingOptions.compare())
    assert(ComparingOptions.compareWithoutSyntax())
  }

}
