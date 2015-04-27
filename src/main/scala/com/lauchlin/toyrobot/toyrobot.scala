package com.lauchlin.toyrobot

import scala.io._
import Math.round

object ToyRobot extends App {
  val Place="""^PLACE (\d),(\d),([A-Z]+)$""".r
  val Directions=Array("NORTH", "EAST", "SOUTH","WEST")
  val table = Table(Point(0,0), Point(4,4))

  def execute(robot: Robot, command: String) = command match {
    case "MOVE"   =>  robot.move
    case "LEFT"   =>  robot.left
    case "RIGHT"  =>  robot.right
    case "REPORT" =>  robot.report((x: Double, y: Double, facing: Double) =>
        println(round(x)+","+round(y)+","+Directions(round(facing.toFloat*2))))
        robot
    case Place(x, y, direction) =>
      if (Directions.contains(direction))
        robot.place(loc => Point(x.toDouble, y.toDouble), facing = Directions.indexOf(direction)/2.0, table = Some(table))
      else
        robot
    case _ => robot
  }

  args.length match {
  case 0 => Iterator.continually(Console.readLine).takeWhile(_ != null).foldLeft(Robot())(execute)
  case 1 => Source.fromFile(args(0)).getLines.foldLeft(Robot())(execute)
  case _ => {
    Console.err.println("usage: ./run.sh <input.txt>")
    System.exit(1)
    }
  }
}
