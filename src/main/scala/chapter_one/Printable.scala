package chapter_one

trait Printable[A] {
  def format(value: A): String
}


object PrintableInstances {
  implicit val printableString: Printable[String] = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(printable.format(value))
}

object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = printable.format(value)

    def print(implicit printable: Printable[A]): Unit = println(format(printable))
  }

}