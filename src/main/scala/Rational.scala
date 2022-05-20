class Rational(n: Int, d: Int):
  require(d != 0)

  def this(n: Int) = this(n, 1)

  private val g = gcd(n.abs, d.abs)

  val numerator: Int = n
  val denominator: Int = d

  override def toString = s"$numerator/$denominator"

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  def +(r: Rational): Rational =
    Rational(numerator * r.denominator + r.numerator * denominator, denominator * r.denominator)

  def *(r: Rational): Rational =
    Rational(numerator * r.numerator, denominator * r.denominator)
