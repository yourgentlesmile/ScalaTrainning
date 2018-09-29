package indi.xc.base
import Array._
/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-09-29 17:05.
  */
class ArrayStructure {
    def ArrayCommand() : Unit = {
        /**
          * _ means that this Array can accept any type value
          */
        var s : Array[_] = new Array[_](10)
    }
    def multiDemensionArray() : Unit = {
        /**
          * we create a two-demensional array
          */
        var s = ofDim[Int](2,2)
    }
    def RangeArray() : Unit = {
        var s = range(1,5)
        for(i <- s) {
            print(i)
            //output "1234"
        }
        var p = range(1,5,2)
        for(i <- p) {
            print(i + " ")
            //output "1 3"
        }
    }
}
