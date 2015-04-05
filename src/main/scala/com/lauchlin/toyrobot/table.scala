package com.lauchlin.toyrobot

case class Table(var lowerLeftCorner: Point, var upperRightCorner: Point) {
  def contains(p: Point) = p >= lowerLeftCorner && p <= upperRightCorner
}

