package com.lauchlin.toyrobot

sealed trait Container { def contains(p: Point) = false }

case object Stasis extends Container

case class Table(val lowerLeftCorner: Point, val upperRightCorner: Point) extends Container {
  override def contains(p: Point) = p >= lowerLeftCorner && p <= upperRightCorner
}

