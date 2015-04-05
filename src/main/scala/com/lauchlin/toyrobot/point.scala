package com.lauchlin.toyrobot

case class Point(var x: Long, var y: Long) {
  def +=(p: Point) {
    x+=p.x
    y+=p.x
  }
  def +(p: Point) = Point(x+p.x, y+p.y)
  def >=(p: Point) = x >= p.x && y >= p.y
  def <=(p: Point) = x <= p.x && y <= p.y
}

