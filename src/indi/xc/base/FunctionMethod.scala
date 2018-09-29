package indi.xc.base

/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-09-29 14:40.
  */
class FunctionMethod {
    def callByName() : Unit = {
        val f = () =>{
            println("get Current Time");
            System.nanoTime()
        }
        val delay = (t: Long) => {
            println("this is delay's body")
            println(t)
        }
        delay(f())
    }
    def specifyParamterName() : Unit = {
        def f(first : Int, second : Int) : Unit = {
            println("Value of first : " + first)
            println("Value of second : " + second)
        }
        /**
          * tips: if you want to use specifyParamterName feature,
          * function shoud be declared with "def"
          * @return
          */
        def caller() : Unit = {
            f(second = 5, first = 8)
        }
        caller()
    }
    def defaultValue() : Unit = {
        def f(a : Int = 5, b : Int = 6): Unit = {
            var sum : Int = 0;
            sum = a + b
            println(sum)
        }
        f()
    }
    def partialFunction() : Unit = {

    }
    def partialAppliedFunction() : Unit = {
        def f(a : Int,b : String) : Unit = {
            print(a + " ")
            print(b)
        }
        var partialF = f(1,_ : String);
        partialF("s")
        //it will output "1 s"
    }
    def highOrderFunction() : Unit = {
        /**
          *
          */
    }
}
