package indi.xc.base

import scala.util.control.Breaks

/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-09-29 13:34.
  */
class ProcessControl {
    def IfCommand() : Unit = {
        var s :Int = 1;
        if(s != 1) {
            print("s is not equal 1")
        } else {
            print("yeah s is equal 1")
        }
    }
    class LoopDemo {
        def forCommand() : Unit = {
            /**
              * using "to" keyword
              */
            for(i <- 1 to 10) {
                print(i + " ")
                //we will get 1 2 3 4 5 6 7 8 9 10
            }

            /**
              * using "until" keyword
              */
            for(i <- 1 until 10) {
                print(i + " ")
                //we will get 1 2 3 4 5 6 7 8 9
            }

            /**
              * iterate list
              */
            var lists : Array[Int] = Array(1,2,3)
            for(i <- lists) {
                print(i)
            }
            /**
              * using "yield" without guards
              * s is a vector
              */
            var s = for(i <- 1 to 10) yield i

            /**
              * using yield with loop expression body
              * and save the variable or expression's value which is at the end of the yield structure
              */
            var t = for(i <- 1 to 10) yield {
                print("get i's double times value")
                i * i
            }

            /**
              * using "yield" with single guards. Saving i which is diviable by 2
              */
            var p = for{i <- 1 to 10 if i % 2 != 0} yield i

            /**
              * using "yield" with multi-guards. Saving i which is diviable by 2 and i is greater than 5
              */
            var q = for{i <- 1 to 10 if i % 2 != 0;if i > 5} yield i
        }
        def whileCommand() : Unit = {
            var i : Int = 1
            while (i < 8) {
                i += 1
            }
        }
        def doWhileCommand() : Unit = {
            var i : Int = 1
            do {
                i += 1
            }while(i < 9)
        }
        def breakCommand() : Unit = {
            var loop = new Breaks
            loop.breakable{
                for(i <- 1 to 10) {
                    if (i == 5) {
                        loop.break
                    }
                }
            }
        }

        def continueCommand() : Unit = {
            var loop = new Breaks
            for(i <- 1 to 10) {
                loop.breakable{
                    if(i == 5) {
                        loop.break
                    }
                    print(i)
                }
            }
        }
    }
}
