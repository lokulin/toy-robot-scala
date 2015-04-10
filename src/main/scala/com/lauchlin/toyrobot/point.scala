package com.lauchlin.toyrobot

case class Point(var x: Double, var y: Double) {
  def +(p: Point) = Point(x+p.x, y+p.y)
  def >=(p: Point) = x >= p.x && y >= p.y
  def <=(p: Point) = x <= p.x && y <= p.y
}

