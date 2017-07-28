//处理单一的一个单词
/**
 * Created by lwq on 17-7-27.
 */

fun dealWord(word: String): String {  //只处理一个单词

    for (i in arrayDict.indices) {
        val dict = openDictFile(arrayDict[i])
        for (item in dict) {
            val word1 = word.toLowerCase()
            val word2 = item.name.toLowerCase().trim()
            if (word1 == word2
                || word1 == word2+"s"  //复数
                || word1 == word2+"es"  //复数
                || word1 == word2+"d"  //过去式
                || word1 == word2+"ed"  //过去式
                || word1 == word2+"ing"  //进行时
                || word1 == word2+"er"  //比较级
                || word1 == word2+"est"  //最高级
            ) {
                when(arrayDict[i]) {
                    "MyWords", "A-Z" -> {totalBlack += 1}
                    "irregular" -> {totalPurple += 1}

                    "Collins5" -> {totalGreen += 1}
                    "Collins4" -> {totalBlue += 1}
                    "Collins3" -> {totalRed += 1}
                    else -> {totalGray += 1}
                }

                return when(arrayDict[i]) {
                    "MyWords" -> "<font color='black'>$word</font>"  //我的词库，已掌握
                    "A-Z" -> "<font color='black'>$word</font>"  //字母表
                    "irregular" -> "<font color='purple'>$word</font>"  //不规则动词

                    "Collins5" -> "<font color='green'>$word</font>"  //5星
                    "Collins4" -> "<font color='blue'>$word</font>"  //4星
                    "Collins3" -> "<font color='red'>$word</font>"  //3星
                    else -> "<font color='gray'>$word</font>"
                }
            }
        }
    }

    tempFile.appendText("$word \n")  //往临时文件中添加词库外的词
    totalGray += 1
    return "<font color='gray'>$word</font>"  //红色，词库之外的词
}