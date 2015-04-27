package com.lauchlin.toyrobot

import Math._

case class Robot(val loc: Point = Point(0,0),
                 val facing: Double = 0.5,
                 val table: Option[Table] = None) {

  def move = place(loc = loc + Point(sin(PI*facing),cos(PI*facing)))

  def right = place(facing = (facing+0.5) % 2)

  def left = place(facing = (((facing-0.5) % 2) + 2) % 2)

  def report(reporter: (Double, Double, Double) => Unit) = this.table.foreach(_ => reporter(loc.x,loc.y,facing))

  def place(loc: Point = this.loc, facing: Double = this.facing, table: Option[Table] = this.table) =
    table match {
      case Some(t) =>
        if (t.contains(loc)) Robot(loc, facing, table)
        else this
      case None => this
    }
}
