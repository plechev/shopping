import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Pavel Lechev <p.lechev@gmail.com>
  * @since 27/11/2016
  */
class CartSpec extends FlatSpec with Matchers {


  "Cart" should "take a list of items scanned at the till and outputs the total cost" in {
    val items = Seq("Apple", "Orange")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    val expected = Products.products("Apple") + Products.products("Orange")
    assert(expected == 0.85, "<- confirm expected cost")
    assert(total == expected, "<- Confirm Cart totals")
  }

  it should """add offer "Buy one, get one free on Apples" """ in {
    val items = Seq("Apple", "Apple", "Orange", "Apple")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    val expected = Products.products("Apple") * 2 + Products.products("Orange") // only pay for 2 apples
    assert(expected == 1.45, "<- confirm expected cost")
    assert(total == expected, "< - Confirm Cart totals for Apple offer")
  }

  it should """add offer "3 for the price of 2 on Oranges"""" in {
    val items = Seq("Orange", "Orange", "Orange")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    val expected = Products.products("Orange") * 3 * 2 / 3
    assert(expected == 0.5, "<- confirm expected cost")
    assert(total == expected, "< - Confirm Cart totals for Oranges offer")
  }

}
