package listMapHead

sealed abstract class MyList[T]:
  def nonEmpty: Boolean
  def map[U](f: T => U): MyList[U]

case class MyNil[T]() extends MyList[T]:
  def nonEmpty: Boolean = false
  def map[U](f: T => U): MyList[U] = MyNil[U]()

case class MyCons[T](head: T, tail: MyList[T]) extends MyList[T]:
  def nonEmpty: Boolean = true
  def map[U](f: T => U): MyList[U] = MyCons(f(head), tail.map(f))

type NonEmptyList[T] = {l: MyList[T] with l.nonEmpty}

def mapOne[T](l: MyList[NonEmptyList[T]]) = l.map(head)

def head[T](l: MyList[T]): T = {
  require(l != MyNil[T]())
  val MyCons(h, _) = l: @unchecked
  h
}