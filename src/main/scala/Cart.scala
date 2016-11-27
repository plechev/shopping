/**
  * @author Pavel Lechev <p.lechev@gmail.com>
  * @since 27/11/2016
  */
class Cart {

  def getTotalCost(items: Seq[String]): Double = {
    val grouped = items.groupBy(k => k)
    // calc Apples:
    var applesTotal = 0.0
    if (grouped.isDefinedAt("Apple")) {
      val allApples = grouped("Apple").size
      val applePrice = Products.products("Apple")
      applesTotal = if (allApples >= 2) {
        allApples % 2 * applePrice + (allApples / 2 * applePrice)
      } else {
        allApples * applePrice
      }
    }

    var orangesTotal = 0.0
    if (grouped.isDefinedAt("Orange")) {
      val allOranges = grouped("Orange").size
      val orangePrice = Products.products("Orange")
      orangesTotal = if (allOranges >= 3) {
        allOranges % 3 * orangePrice + (allOranges / 3 * 2 * orangePrice)
      } else {
        allOranges * orangePrice
      }
    }

    applesTotal + orangesTotal
  }

}
