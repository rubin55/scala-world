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

  @targetName("add")
  def +(r: Rational): Rational =
    Rational(numerator * r.denominator + r.numerator * denominator, denominator * r.denominator)

  @targetName("multiply")
  def *(r: Rational): Rational =
    Rational(numerator * r.numerator, denominator * r.denominator)
