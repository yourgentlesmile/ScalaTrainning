package indi.xc.base

/**
  * todo
  *
  * @Author XiongCheng 
  * @version V1.0
  * @Date 2018-09-29 17:18.
  */
class CollectionStructure {
    def ListCommand() : Unit = {
        var x = List(1,2,3,4)
    }
    def SetCommand() : Unit = {
        var x = Set(1,2,4,5)
    }
    def MapCommand() : Unit = {
        /**
          * when you call Map's 'get' function,you will recieve a Some value if key exist,if not ,it will be None
          */
        var x = Map("one" -> 1, "two" -> 2, "three" -> 3)
    }
    def TupleCommand() : Unit = {
        var x = (1,"2")
    }
    def OptionCommand() : Unit = {
        val x : Option[Int] = Some(5)
        val t : Option[Int] = None
    }
    def IteratorCommand() : Unit = {
        val it = Iterator(1,2,3,4,5)
        while (it.hasNext) {
            print(it.next())
        }
        //get max in this collection
        it.max
        //get min in this collection
        it.min
        //get num of the element in the collection
        it.size; it.length
    }
}
