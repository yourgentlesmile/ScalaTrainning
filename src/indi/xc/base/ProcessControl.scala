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
            var loop = new Breaks()
            loop.breakable{
                for(i <- 1 to 10) {
                    if (i == 5) {
                        loop.break()
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
    class PatternMatching {
        def simplePatternMatching(): Unit = {
            var s : String = "2"
            s match {
                case "1" => "one"
                case "2" => "two"
                //missing match
                case _ => "NotFound"
            }
        }
        def caseClass(): Unit = {
            val alice = new Person("Alice", 25)
            val bob = new Person("Bob", 32)
            val charlie = new Person("Charlie", 32)

            for (person <- List(alice, bob, charlie)) {
                person match {
                    case Person("Alice", 25) => println("Hi Alice!")
                    case Person("Bob", 32) => println("Hi Bob!")
                    case Person(name, age) =>
                        println("Age: " + age + " year, name: " + name + "?")
                }
            }
            case class Person(name : String, age : Int)
        }
        def caseClassWithGuard(): Unit = {
            abstract class Notification

            case class Email(sender: String, title: String, body: String) extends Notification

            case class SMS(caller: String, message: String) extends Notification

            case class VoiceRecording(contactName: String, link: String) extends Notification

            def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
                notification match {
                    case Email(email, _, _) if importantPeopleInfo.contains(email) =>
                        "You got an email from special someone!"
                    case SMS(number, _) if importantPeopleInfo.contains(number) =>
                        "You got an SMS from special someone!"
                    case other =>
                        "" // nothing special, delegate to our original showNotification function
                }
            }
            val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
            val someSms = SMS("867-5309", "Are you there?")
            val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
            val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
            val importantSms = SMS("867-5309", "I'm here! Where are you?")
        }
        def matchingTypeOnly(): Unit = {
            abstract class Device
            case class Phone(model: String) extends Device{
                def screenOff = "Turning screen off"
            }
            case class Computer(model: String) extends Device {
                def screenSaverOn = "Turning screen saver on..."
            }

            def goIdle(device: Device) = device match {
                case p: Phone => p.screenOff
                case c: Computer => c.screenSaverOn
            }
        }
    }
}
