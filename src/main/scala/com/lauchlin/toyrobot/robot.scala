package com.lauchlin.toyrobot

import Math._

case class Robot(val loc: Point, val facing: Double, val table: Container) {

  def place(x: Double, y: Double, facing: Double, table: Table) = newRobot(Point(x, y), facing, table)
  def move  = newRobot(loc + Point(cos(PI*facing),sin(PI*facing)), facing, table) 
  def left  = newRobot(loc, (facing+0.5) % 2, table)
  def right = newRobot(loc, (((facing-0.5) % 2) + 2) % 2, table)
  def report(reporter: (Double, Double, Double) => Unit) = 
        if(table.isInstanceOf[Table]) reporter(loc.x,loc.y,facing)

  private def newRobot(loc: Point, facing: Double, table: Container) = 
    if (table.isInstanceOf[Table] && table.contains(loc)) Robot(loc, facing, table)
    else this

}
