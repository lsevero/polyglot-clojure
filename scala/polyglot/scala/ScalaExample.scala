package polyglot.scala

trait Bark {
    def bark_sound: String
    def bark()
}
trait Dog {
    def breed: String
    def color: String
}
class SaintBernard extends Dog with Bark {
    val breed = "Saint Bernard"
    val color = "brown"
    val bark_sound = "Woof"

    def bark() = println(s"${this.breed} says ${this.bark_sound}!!")
}

class ScalaExample(namee: String) {
  val name = namee

  def sayHello() = println(s"Hello from Scala ${this.name}!!")
}

object ScalaExample {
  val sao_bernardo = new SaintBernard()
  def sayHello() = println(s"Hello from Scala unknown person!!")
}
