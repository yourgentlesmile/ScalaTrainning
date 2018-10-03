package indi.xc.base

/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-10-03 10:14.
  */
class TraitCommand {
    /**
      * trait -> "interface"
      * isInstanceOf is similar to "instanceof"
      * obj.asInstanceOf[T]  ->  (T)obj
      * classOf -> obj.class
      *
      * a class can inherite more than one trait
      */
    def traitKeyword (): Unit = {
        trait Equal {
            def isEqual(x : Any) : Boolean
            def isNotEqual(x : Any) : Boolean = !isEqual(x)
        }
        class Point(xc : Double, yc : Double) extends Equal {
            var x: Double = xc
            var y: Double = yc
            override def isEqual(x: Any): Boolean = x.isInstanceOf[Point] && x.asInstanceOf[Point].x == xc
        }
    }
}
