@main def hello(): Unit =
  val a = Rational(3,6)
  val b = Rational(45,93)
  val c = a + b
  println(f"A is $a B = $b, they add up to $c")
