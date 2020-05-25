import JsonWriterInstances._
import JsonSyntax._

class Test extends App {

  override def main(args: Array[String]) = {
    // Without json syntax
    val p1 = Json.toJson(Person("Anuj", "anujmaxagr@gmail.com"))


    // With Json syntax, this feels like the toJson is part of Person class
    val p2 = Person("Anuj", "anujmaxagr@gmail.com").toJson

    assert(p1 == p2)


    // can also use implicitly to summon any value from implicit scope
    //implicitly[JsonWriter[String]]
  }

}
