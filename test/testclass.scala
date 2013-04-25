
import annotation.tailrec

class TestClass {
  @tailrec
  final def foo(i: Int): Int = if (i < 0) i else foo(i-1)
  
  def change = 2.0
}