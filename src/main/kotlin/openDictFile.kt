//打开相应的词典文件，并返回数组
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
            arrayOfWord.add(Word(word[0], word[1], word[2]))
        } else {
            arrayOfWord.add(Word(line, "", ""))
        }
    }
    return arrayOfWord
}