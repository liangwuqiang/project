//程序主入口
import java.io.File

/**
 * Created by lwq on 17-7-27.
 */

val homePath = "/home/lwq/Desktop/Reading/src/main/kotlin/"
val inputFile = File(homePath + "input/input.txt")  //原文
val outputFile = File(homePath + "output/output.html")  //输出结果
val tempFile = File(homePath + "output/temp.txt")  //输出不能处理的单词

val arrayDict = arrayOf(  //注意排列顺序
    "A-Z"  //字母表
    , "MyWords"  //已掌握的单词
    , "Collins5"  //柯林斯分频词库(五星)
    , "Collins4"  //柯林斯分频词库(四星)
    , "Collins3"  //柯林斯分频词库(三星)
    , "irregular" //不规则动词
)

var totalBlack = 0
var totalPurple = 0

var totalGreen =  0
var totalBlue = 0
var totalRed = 0

var totalGray = 0

fun main(args: Array<String>) {

    createHTML()
}