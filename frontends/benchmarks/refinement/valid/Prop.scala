package prop

import stainless.lang.Prop.{_, given}
import stainless.annotation.ghost

object A:
  def foo(i : Int, j: Int)(using @ghost iEqJ : Prop with i == j) = i
  def bar() =
    foo(42, 42)
