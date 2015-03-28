package toyrobot

class Robot(nt: Table) {
  var x = 0
  var y = 0
  var compass = Array( new Direction("NORTH", 0, 1),
                      new Direction("EAST",  1, 0),
                      new Direction("SOUTH", 0,-1),
                      new Direction("WEST", -1, 0)
                    )
  var placed = false
  val table = nt

  class Direction(n: String, nx: Integer, ny: Integer) {
    def name = n
    def x = nx
    def y = ny
  }

  def place(nx: Integer, ny: Integer, ndirection: String) {
    var r = compass.indexWhere(_.name == ndirection)
    if( r != -1 ) {
      compass=compass.drop(r)++compass.take(r)
      x = nx
      y = ny
      placed = true 
    }
  }

  def move() {
    if(placed) {
      x += compass.head.x
      y += compass.head.y
    }
  }

  def left() {
    if(placed) {
      compass = compass.takeRight(1)++compass.dropRight(1)
    }
  }

  def right() {
    if(placed) {
     compass = compass.drop(1)++compass.take(1)
    }
  }

  def report {
    println(x + "," + y + "," + compass.head.name)
  }

}
