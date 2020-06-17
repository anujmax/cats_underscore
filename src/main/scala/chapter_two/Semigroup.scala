package chapter_two

object Semigroup {
  trait Semigroup[A] {
    def combine(x: A, y: A) : A
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty : A
  }

  object Monoid {
    def apply[A](implicit monoid: Monoid[A]) = monoid
  }


  implicit  val booleanAndMonoid : Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true

    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit  val booleanOrMonoid : Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false

    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit  val booleanEitherMonoid : Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false

    override def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)
  }

  implicit  val booleanXnorMonoid : Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true

    override def combine(x: Boolean, y: Boolean): Boolean = (x && !y) && (!x && y)
  }


  implicit  def  setUnionMonoid[A] : Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty[A]

    override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
  }

  implicit def setIntersectionMonoid[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
  }

}
