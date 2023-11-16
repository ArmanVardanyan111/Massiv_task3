import javax.xml.crypto.dsig.keyinfo.KeyValue

fun main(args: Array<String>) {
    var words = arrayOf ('А', 'Б', 'В', 'Г', 'Д', 'Е',
                            'Ё', 'Ж', 'З', 'И', 'Й',
                            'К', 'Л', 'М', 'Н', 'О',
                            'П', 'Р', 'С', 'Т', 'У',
                            'Ф', 'Х', 'Ц', 'Ч', 'Ш',
                            'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я');

    var i = 0;
    var symbols_ = Array(33, {i++})

    var text = readln().toString()
    var key = readln().toString()

    var textValue = text.length
    var keyValue = key.length

    if (textValue > keyValue)
    {
        var a = 0
        while (textValue > keyValue)
        {
            key = key.plus(key)
            keyValue = key.length
        }
    }

    var cipher = ""

    for (j in 0 until textValue)
    {
        var a = -1
        var b = -1
        do {
            for (g in 0 until 33) {
                if (words[g] == text[j]) {
                    a = g
                }
                if (words[g] == key[j]) {
                    b = g
                }
            }
        } while (a == -1 || b == -1)

        if (a+b > 32)
        {
            cipher += words[a+b-33+1]
        }
        else
        {
            cipher += words[a+b+1]
        }
    }

    println(cipher)
}