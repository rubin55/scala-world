import scala.annotation.{tailrec, targetName}

class Rational(n: Int, d: Int):
  require(d != 0)

  def this(n: Int) = this(n, 1)

  private val g = gcd(n.abs, d.abs)

  private val numerator: Int = n
  private val denominator: Int = d

  override def toString = s"$numerator/$denominator"

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  @targetName("add-rational")
  def +(r: Rational): Rational =
    Rational(numerator * r.denominator + r.numerator * denominator,
      denominator * r.denominator)

  @targetName("add-integer")
  def +(i: Int): Rational =
    Rational(numerator + i * denominator,
      denominator)

  @targetName("minus-rational")
  def -(r: Rational): Rational =
    Rational(numerator * r.denominator - r.denominator * denominator,
      denominator * r.denominator)

  @targetName("minus-integer")
  def -(i: Int): Rational =
    Rational(numerator -i * denominator,
      denominator)

  @targetName("multiply-rational")
  def *(r: Rational): Rational =
    Rational(numerator * r.numerator,
      denominator * r.denominator)

  @targetName("multiply-integer")
  def *(i: Int): Rational =
    Rational(numerator * i,
      denominator)

  @targetName("divide-rational")
  def /(r: Rational): Rational =
    Rational(numerator * r.denominator,
      denominator * r.numerator)

  @targetName("divide-integer")
  def /(i: Int): Rational =
    Rational(numerator,
      denominator * i)
