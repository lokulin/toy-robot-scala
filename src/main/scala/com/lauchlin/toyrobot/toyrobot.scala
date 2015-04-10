package com.lauchlin.toyrobot

import scala.io._
import Math.round

object ToyRobot extends App {
    val Place="""^PLACE (\d),(\d),([A-Z]+)$""".r
    val Directions=Array("EAST","NORTH","WEST","SOUTH")
    val table = Table(Point(0,0), Point(4,4))
    var robot = Robot(Point(0,0), 0.0, Stasis)
    
  def execute(command: String) = command match {
      case "MOVE"   =>  robot = robot.move
      case "LEFT"   =>  robot = robot.left
      case "RIGHT"  =>  robot = robot.right
      case "REPORT" =>  robot.report((x: Double, y: Double, facing: Double) => 
          println(round(x)+","+round(y)+","+Directions(round(facing.toFloat*2))))
      case Place(x, y, direction) => 
        if (Directions.contains(direction)) 
          robot = robot.place(x.toDouble, y.toDouble, Directions.indexOf(direction)/2.0, table)
      case _ => ()
    }

  if ( args.length == 1 ) {
    Source.fromFile(args(0)).getLines.foreach(execute)
  } else {
    Console.err.println("usage: ./run.sh <input.txt>")
    System.exit(1) 
  }
}
