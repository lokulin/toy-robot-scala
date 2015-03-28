class Point(var x: Long, var y: Long) {
  def +=(dx: Long, dy: Long) {
    x+=dx
    y+=dy
  }
}
