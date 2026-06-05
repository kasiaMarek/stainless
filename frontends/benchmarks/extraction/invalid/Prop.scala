package prop
import stainless.lang.{_, given}
import stainless.annotation.ghost

object A:
  def foo(i : Int, j: Int)(using iEqJ : Prop with i == j) = i
  def bar() =
    foo(42, 42)
