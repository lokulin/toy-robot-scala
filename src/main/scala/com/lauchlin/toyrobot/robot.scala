package com.lauchlin.toyrobot

import Math._

case class Robot(val loc: Point = Point(0,0), 
                 val facing: Double = 0.5, 
                 val table: Container = Stasis) {

  def place(x: Double, y: Double, facing: Double, table: Table) = newRobot(Point(x, y), facing, table)

  def move  = newRobot(loc = loc + Point(cos(PI*facing),sin(PI*facing))) 

  def left  = newRobot(facing = (facing+0.5) % 2)

  def right = newRobot(facing = (((facing-0.5) % 2) + 2) % 2)

  def report(reporter: (Double, Double, Double) => Unit) = 
        if(table.isInstanceOf[Table]) reporter(loc.x,loc.y,facing)

  private def newRobot(loc: Point = this.loc, facing: Double = this.facing, table: Container = this.table) = 
    if (table.isInstanceOf[Table] && table.contains(loc)) Robot(loc, facing, table)
    else this

}
