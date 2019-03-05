object HelloWorld {
  def main(args: Array[String]): Unit = {
    System.out.print("HelloWorld")
    print(gcdLoop(3, 13))
  }

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
}
