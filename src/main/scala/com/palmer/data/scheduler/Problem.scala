package com.palmer.data.scheduler

case class Order(product: String, amount: Double)

case class Line(id: String, totalTime: Long, rates: Seq[LineRate])
case class LineRate(product: String, rate: Double)

class Problem(val orders: Seq[Order], val lines: Seq[Line]) {
  
  private val productOrderMap: Map[String, Double] = orders.map(o => (o.product, o.amount)).toMap
  
  def getOrderAmount(productId: String): Double = productOrderMap(productId)
  
}
