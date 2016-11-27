import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Pavel Lechev <p.lechev@gmail.com>
  * @since 27/11/2016
  */
class CartSpec extends FlatSpec with Matchers {


  "Cart" should "take a list of items scanned at the till and outputs the total cost" in {
    val items = Seq("")
    val cart = new Cart()
    val total = cart.getTotalCost(items)
    assert(total == 15)
  }

}
