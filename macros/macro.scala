
import language.experimental.macros
import scala.reflect.macros.Context

object Macros {
  def annotationFinder[A]: String = macro annotationFinder_impl[A]
  
  def annotationFinder_impl[A: c.WeakTypeTag](c: Context):c.Expr[String] = {
      import c.universe._

      val tpe = weakTypeOf[A]
      val fooAnnotations = tpe.members.collect { case m: MethodSymbol if m.name.decoded.startsWith("foo") =>
        println(s"Method $m has annotations ${m.annotations}")
        s"Method ${m.name.decoded} with annotations ${m.annotations}"
      }
        
      c.Expr[String](Literal(Constant(fooAnnotations.head)))
  }
}