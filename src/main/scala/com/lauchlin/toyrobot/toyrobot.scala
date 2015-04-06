package com.lauchlin.toyrobot

import scala.io._
import Math._

case class Point(var x: Long, var y: Long) {
  def +(p: Point) = Point(x+p.x, y+p.y)
  def >=(p: Point) = x >= p.x && y >= p.y
  def <=(p: Point) = x <= p.x && y <= p.y
}

object ToyRobot extends App {
  var location = Point(0,0)
  var facing = -1
  val Directions=Array("EAST","NORTH","WEST","SOUTH")
  object Table {
      val llc = Point(0,0)
      val urc = Point(4,4)
      def contains(p: Point) = p >= llc && p <= urc
    }
  val Place="""^PLACE (\d),(\d),([A-Z]+)$""".r

  def execute(command: String) = command match {
    case "MOVE" => if (placed && Table.contains(lookingAt)) location = lookingAt
    case "REPORT" => if (placed) println(location.x+","+location.y+","+Directions(facing))
    case "LEFT" => if (placed) facing = (facing+1) % Directions.length
    case "RIGHT" => if (placed) facing = floorMod(facing-1, Directions.length)
    case Place(x, y, direction) => 
      if (Directions.contains(direction) && 
            Table.contains(Point(x.toInt,y.toInt))) {
        location= Point(x.toInt, y.toInt)
        facing = Directions.indexOf(direction)
      }
    case _ => ()
  }

  def lookingAt = location+Point(round(cos(PI*facing/2.0)),round(sin(PI*facing/2.0)))
  def placed = facing != -1

  if ( args.length == 1 ) {
    Source.fromFile(args(0)).getLines.foreach(execute)
  } else {
    Console.err.println("usage: ./run.sh <input.txt>")
    System.exit(1) 
  }
}
