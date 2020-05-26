package chapter_one
import JsonWriterInstances._
import org.scalatest._
import JsonSyntax._


class JsonWriterTest extends FunSuite {

  test("An interface Object serialize should equal to interface syntax serialize") {

    // Without json syntax
    val p1 = Json.toJson(Person("Anuj", "anujmaxagr@gmail.com"))


    // With Json syntax, this feels like the toJson is part of Person class
    val p2 = Person("Anuj", "anujmaxagr@gmail.com").toJson

    assert(p1 == p2)
    // can also use implicitly to summon any value from implicit scope
    //implicitly[JsonWriter[String]]
  }


}
