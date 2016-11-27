import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Pavel Lechev <p.lechev@gmail.com>
  * @since 27/11/2016
  */
class CartSpec extends FlatSpec with Matchers {


  "Cart" should "take a list of items scanned at the till and outputs the total cost" in {
    val items = Seq("Apple", "Apple", "Orange", "Apple")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    val expected = Products.products("Apple") * 3 + Products.products("Orange")
    assert(expected == 2.05, "<- confirm expected cost")
    assert(total == 2.05, "<- Confirm Cart totals")
  }

  it should """add offer "Buy one, get one free on Apples" """ in {
    val items = Seq("Apple", "Apple", "Orange", "Apple")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    val expected = Products.products("Apple") * 2 + Products.products("Orange") // only pay for 2 apples
    assert(expected == 1.45, "<- confirm expected cost")
    assert(total == 1.45, "< - Confirm Cart totals for Apple offer")
  }

}
