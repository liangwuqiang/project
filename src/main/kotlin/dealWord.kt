//处理单一的一个单词
/**
 * Created by lwq on 17-7-27.
 */

fun dealWord(word: String): String {  //只处理一个单词

    for (i in arrayDict.indices) {
        val dict = openDictFile(arrayDict[i])
        for (item in dict) {
            val wordFromArticle = word.toLowerCase()  //来自文章
            val wordFromDict = item.name.toLowerCase()  //来自词典
            if (wordFromArticle == wordFromDict
                || wordFromArticle == wordFromDict + "s"  //复数
                || wordFromArticle == wordFromDict + "es"  //复数
                || wordFromArticle == wordFromDict + "d"  //过去式
                || wordFromArticle == wordFromDict + "ed"  //过去式
                || wordFromArticle == wordFromDict + "ing"  //进行时
                || wordFromArticle == wordFromDict + "er"  //比较级
                || wordFromArticle == wordFromDict + "est"  //最高级
            ) {
                when(arrayDict[i]) {
                    "MyWords", "A-Z" -> {totalBlack += 1}
                    "irregular" -> {totalPurple += 1}

                    "high_freq" -> {totalGreen += 1}
                    "medium_freq" -> {totalBlue += 1}
                    "low_freq" -> {totalRed += 1}
                    else -> {totalGray += 1}
                }

                return when(arrayDict[i]) {
                    "MyWords" -> "<font color='black'>$word</font>"  //我的词库，已掌握
                    "A-Z" -> "<font color='black'>$word</font>"  //字母表
                    "irregular" -> "<font color='purple'>$word</font>"  //不规则动词

                    "high_freq" -> "<font color='green'>$word</font>"  //5星
                    "medium_freq" -> "<font color='blue'>$word</font>"  //4星
                    "low_freq" -> "<font color='red'>$word</font>"  //3星
                    else -> "<font color='gray'>$word</font>"
                }
            }
        }
    }

    tempFile.appendText("$word \n")  //往临时文件中添加词库外的词
    totalGray += 1
    return "<font color='gray'>$word</font>"  //红色，词库之外的词
}