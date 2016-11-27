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
    assert(expected == 11.0, "<- confirm expected cost")
    assert(total == 11.0, "Confirm Cart totals")
  }

}
