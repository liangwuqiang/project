//打开相应的词典文件,并返回数组. 英文单词去掉单引号和多余的空格
import java.io.File

/**
 * Created by lwq on 17-7-27.
 */

fun openDictFile(dict: String): ArrayList<Word> {

    val arrayOfWord = arrayListOf<Word>()

    val file = File(homePath + "dict/" + dict + ".dict")
    for (line in file.readLines()) {
        if ("[" in line && "]" in line) {
            val word = line.split("[", "]")
            if ("\'" in word) {
                arrayOfWord.add(Word(word[0].split("\'")[0].trim(), word[1], word[2]))
            } else {
                arrayOfWord.add(Word(word[0].trim(), word[1], word[2]))
            }
        } else {  //解决词库只有单词的问题
            if ("\'" in line) {  //解决单词中包含'单引号的问题
                arrayOfWord.add(Word(line.split("\'")[0].trim(), "", ""))
            } else {
                arrayOfWord.add(Word(line.trim(), "", ""))
            }
        }
    }
    return arrayOfWord
}