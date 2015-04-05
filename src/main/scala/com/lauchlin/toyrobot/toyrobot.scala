package com.lauchlin.toyrobot

import scala.io._

object ToyRobot extends App {
    val Place="""^PLACE (\d),(\d),([A-Z]+)$""".r

    def execute(command: String) = command match {
      case "MOVE" => robot.move()
      case "REPORT" => robot.report
      case "LEFT" => robot.left()
      case "RIGHT" => robot.right()
      case Place(x, y, direction) => robot.place(x.toInt, y.toInt, direction)
      case _ => ()
    }

    var robot=new Robot(new Table(new Point(0,0), new Point(4,4)))
    
    if ( args.length == 1 ) {
      Source.fromFile(args(0)).getLines.foreach(execute)
    } else {
      Console.err.println("usage: ./run.sh <input.txt>")
      System.exit(1) 
    }
}
