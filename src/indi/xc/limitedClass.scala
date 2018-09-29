package indi.xc

/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-09-29 8:59.
  */
class limitedClass {
    class Inner {
        private def f(): Unit = {
            println("f");
        }
        class InnerMost {
            f();
        }
    }
}
