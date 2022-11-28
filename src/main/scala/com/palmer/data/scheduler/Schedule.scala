package com.palmer.data.scheduler

case class LineAssignments(lineId: String, products: Seq[ProductAssignment])
case class ProductAssignment(productId: String, amount: Long)

class Schedule(lineAssignments: Seq[LineAssignments]) {

  
  
}
