package com.lauchlin.toyrobot

import Math._

class Robot(var table: Table) {
  var loc = Point(0,0)
  var facing = -1
  val Directions=Array("EAST","NORTH","WEST","SOUTH")

  def place(nx: Long, ny: Long, nDirection: String) =
    if (Directions.contains(nDirection) && table.contains(Point(nx,ny))) {
      loc = Point(nx, ny)
      facing = Directions.indexOf(nDirection)
    }

  def move()  = if (placed && table.contains(lookingAt)) loc = lookingAt
  def left()  = if (placed) facing = (facing+1) % Directions.length
  def right() = if (placed) facing = floorMod(facing-1, Directions.length)
  def report  = if (placed) println(loc.x+","+loc.y+","+Directions(facing))

  private def lookingAt = loc+Point(round(cos(PI*facing/2.0)),round(sin(PI*facing/2.0)))
  private def placed = facing != -1
}
