import java.io.File

/**
 * Created by lwq on 17-7-28.
 */
fun main(args: Array<String>) {
    if (args.size != 1) {
        println("请提供一个命令行参数,作为打开的文件名!!!")
        return
    }
    val inputFile = File(homePath + args[0])
    val stringBuilder = StringBuilder()
    for (line in inputFile.readLines()) {
        if ("[" in line && "]" in line) {
            stringBuilder.append(line.split("[", "]")[0] + "\n")
        }
    }
    println(stringBuilder)

    val outputFile = File(homePath + "output/temp.txt")
    outputFile.writeText(stringBuilder.toString())
}