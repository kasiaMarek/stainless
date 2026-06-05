package prop2

import stainless.lang.Prop.{_, given}
import stainless.collection._
import stainless.annotation._

object A:
  def zip[T, S](xs : List[T], ys: List[S])(using @ghost xsEqYs : Prop with xs.length == ys.length): List[(T, S)] =
    (xs, ys) match
      case (Nil(), Nil()) => Nil()
      case (Cons(xh, xt), Cons(yh, yt)) =>
        Cons((xh, yh), zip(xt, yt))

  def bar: Unit =
    val l1 = List(1, 2, 3)
    val l2 = List(4, 5, 6)
    val l2Nil = l2 ++ Nil[Int]()
    zip(l1, l2Nil)(using addNil(l2))

  @ghost def addNil[T](@induct xs: List[T]): {r: Prop with xs ++ Nil[T]() == xs } = ()
