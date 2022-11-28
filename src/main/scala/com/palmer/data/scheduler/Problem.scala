package com.palmer.data.scheduler

case class Order(product: String, amount: Long)

case class Line(id: String, totalTime: Long, rates: Seq[LineRate], changes: Seq[ChangeTime])
case class LineRate(product: String, rate: Double)
case class ChangeTime(productA: String, productB: String, time: Long)

case class Problem(orders: Seq[Order], lines: Seq[Line])
