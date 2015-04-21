package com.lauchlin.toyrobot

case class Table(val lowerLeftCorner: Point, val upperRightCorner: Point) {
  def contains(p: Point) = p >= lowerLeftCorner && p <= upperRightCorner
}

