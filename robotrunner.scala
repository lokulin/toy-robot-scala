import toyrobot._

object RobotRunner {
  def main(args: Array[String]) {
    var robot=new Robot(new Table(0,0,4,4))
    println("I live!")
    robot.left()
    robot.report
    robot.move
    robot.report
    robot.right()
    robot.report
    robot.report
    robot.place(1,1,"EAST")
    robot.report
    robot.move()
    robot.report
    robot.move()
    robot.report
    robot.left()
    robot.report
    robot.left()
    robot.report
    robot.move
    robot.report
    robot.right()
    robot.report
    robot.right()
    robot.report
  }
}
