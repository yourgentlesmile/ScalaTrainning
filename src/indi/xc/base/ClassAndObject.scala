package indi.xc.base
import math._
/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-10-03 9:13.
  */
class ClassAndObject {
    class Person(ages : Int,sexs : String) {
        var age : Int = ages;
        var sex : String = sexs;
        var marker : String = "marker";
    }
    def inheritanceKeyword() : Unit = {
        class Male(ages : Int, sexs : String) extends Person(ages,sexs) {

        }
    }
    def overrideKeyword() : Unit = {
        /**
          * override super class' method
          * @param ages
          * @param sexs
          */
        class Male(ages : Int, sexs : String) extends Person(ages,sexs) {
            override def toString: String = "this method has been overrided";
        }
        /**
          * override super class' member
          * @param ages
          * @param sexs
          */
        class Female(ages : Int, sexs : String) extends Person(ages, sexs) {
            override var marker : String = "printer";
        }
    }
    def singletonObject() : Unit = {
        object logger {
            def info (message : String): Unit = {
                println("INFO + " + message)
            }
        }
        logger.info("test singleton object output,yeah~")
    }
    def companionObject(): Unit = {
        //Because of the calculateArea is defined after than Circle main class so that we need to import himself
        import Circle._
        class Circle(radius : Double) {
            def area : Double = calculateArea(radius)
        }
        object Circle {
            def calculateArea(radius : Double) : Double = Pi * pow(radius,2)
        }
    }
}
