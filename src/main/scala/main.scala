package aprak.lerning.course

//import org.apache.hadoop.yarn.webapp.hamlet2.HamletSpec.Scope.col
import org.apache.spark.sql.classic.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.StringType

object Main {
  def main(args : Array[String]): Unit = {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val spark = SparkSession.builder()
      .appName("spark-vedio-course")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .config("spark.driver.host", "127.0.0.1")
      .getOrCreate()

//    val df = spark.read
//      .option("header", value= true)
//      .option("inferSchema", value= true)
//      .csv("Data/AAPL.csv")

    val df: DataFrame = spark.read
      .option("header", value= true)
      .option("inferSchema", value= true)
      .csv("Data/AAPL.csv")


    df.show()
    df.printSchema()

    df.select("Date", "Open", "Close").show()
    val column = df("Date")
    col("Date")
    import spark.implicits._
    $"Date"

    df.select(col("Date"), $"Open", df("Close")).show()

//vedio - 6
    println("******************************************************************************************************************************")
    println("Vedio - 6")
    val column6 = df("Open")
    val newColumn6 = column6 + 2.0
    val columnString = column6.cast(StringType)

    df.select(column6, newColumn6, columnString)
//      .filter(newColumn6 > 2.0)
//      .filter(newColumn6 > column6)
//      .filter(newColumn6 === column6)
      .show()

 }//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

}

