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
      applesTotal = allApples % 2 * Products.products("Apple") + allApples / 2 * Products.products("Apple")
    }

    var orangesTotal = 0.0
    if (grouped.isDefinedAt("Orange")) {
      val allOranges = grouped("Orange").size
      val orangePrice = Products.products("Orange")
      orangesTotal = (if (allOranges > 3) {
        allOranges % 3 * orangePrice
      } else {
        0
      }) + (allOranges / 3 * 2 * orangePrice)
    }

    applesTotal + orangesTotal
  }

}
