package com.lauchlin.toyrobot

case class Point(val x: Double, val y: Double) {
  def +(p: Point) = Point(x+p.x, y+p.y)
  def >=(p: Point) = x >= p.x && y >= p.y
  def <=(p: Point) = x <= p.x && y <= p.y
}

