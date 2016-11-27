/**
  * @author Pavel Lechev <p.lechev@gmail.com>
  * @since 27/11/2016
  */
class Cart {

  def getTotalCost(items: Seq[String]): Double = {
    items.foldRight(0.0)((i, t) => t + Products.products(i))
  }

}
