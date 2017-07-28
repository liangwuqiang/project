//创建html文件，使用浏览器来阅读

/**
 * Created by lwq on 17-7-27.
 */

fun createHTML() {
    tempFile.writeText("")  //清空临时文件

    val word = StringBuilder()
    val text = StringBuilder()
    val html = StringBuilder()

    for (line in inputFile.readLines()) {  //逐行处理
        text.append("<p>")
        var i = 0
        for (char in line) {  //对每行进行逐字符处理
            i++
            if (char in 'A'..'Z' || char in 'a'..'z') {  //进行文字的拼接
                word.append(char.toString())
                if (i == line.length) {  //行结尾,输出
                    if (word.toString() != "") {
                        //将拼接好的文字，在词典中查询，添加相应的颜色，再拼接到文本中
                        text.append(dealWord(word.toString()))
                        word.delete(0, word.length)  //结束后清空变量
                    }
                }
                continue
            }
            if (word.toString() != "") {
                //将拼接好的文字，在词典中查询，添加相应的颜色，再拼接到文本中
                text.append(dealWord(word.toString()))
                word.delete(0, word.length)  //结束后清空变量
            }
            text.append(char.toString())  //拼接特殊文字
        }

        text.append("</p>")
    }

    //各种颜色所占比例
    val sumTotal = totalBlack+totalGreen+totalBlue+totalPurple+totalRed+totalGray

    val percentBlack = totalBlack * 100 / sumTotal

    val percentGreen = totalGreen * 100 / sumTotal
    val percentBlue = totalBlue * 100 / sumTotal
    val percentRed = totalRed * 100 / sumTotal
    val percentGray = totalGray * 100 / sumTotal

    val percentPurple = totalPurple * 100 / sumTotal

    //文档开头部分
    html.append("""
        <!DOCTYPE html>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>单词分级颜色显示</title>
        </head>
        <body>
            <p>说明：</p>
            <p>
                <font color="black">[掌握 $percentBlack%]</font>

                <font color="green">[高频 $percentGreen%]</font>
                <font color="blue">[中频 $percentBlue%]</font>
                <font color="red">[低频 $percentRed%]</font>
                <font color="gray">[生僻 $percentGray%]</font>

                <font color="purple">[不规则 $percentPurple%]</font>
            </p>
    """)

    //文档中间部分
    html.append(text)

    //文档结尾部分
    html.append("""
        </body>
        </html>
    """)


    outputFile.writeText(html.toString())
}