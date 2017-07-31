//程序主入口
import java.io.File

/**
 * Created by lwq on 17-7-27.
 */

val homePath = "/home/lwq/Desktop/Reading/src/main/kotlin/"
val inputFile = File(homePath + "input/input.txt")  //原文
val outputFile = File(homePath + "output/output.html")  //输出结果
val tempFile = File(homePath + "output/temp.txt")  //输出不能处理的单词

val arrayDict = arrayOf("null"  //注意排列顺序
    , "high_freq"  //高频词
    , "medium_freq"  //中频词
    , "low_freq"  //低频词
     , "irregular" //不规则动词
    , "MyWords"  //已掌握的单词
    , "A-Z"  //字母表
)

var totalBlack = 0
var totalPurple = 0

var totalGreen =  0
var totalBlue = 0
var totalRed = 0

var totalGray = 0

fun main(args: Array<String>) {
    tempFile.writeText("")  //清空临时文件
    for (i in 0..0){
        val startTime = System.currentTimeMillis()
        createHTML()
        val endTime = System.currentTimeMillis()
        println("程序完成时间:" + (endTime - startTime).toString())
//        tempFile.appendText((endTime - startTime).toString() + "\n")
    }
}