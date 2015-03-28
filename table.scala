package toyrobot

class Table(nx: Integer, ny: Integer, nxx: Integer, nyy: Integer) {
  def x = nx
  def y = ny
  def xx = nxx
  def yy = nyy
  
  def contains(nx: Integer, ny: Integer) = {
    if ( nx >= x && nx <= xx && ny >= y && y <= ny ) true
    else false
  }
}
