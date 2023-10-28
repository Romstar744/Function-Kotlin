fun main() {
    val originalMessage = "ШИФРВИЖЕНЕР"
    val key = "КОД"

    val encryptedMessage = encryptVigenere(originalMessage, key)
    println("Зашифрованное сообщение: $encryptedMessage")
}

fun encryptVigenere(message: String, key: String): String {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val encryptedMessage = StringBuilder()

    for (i in message.indices) {
        val messageChar = message[i]
        val keyChar = key[i % key.length]
        val messageCharIndex = alphabet.indexOf(messageChar)
        val keyCharIndex = alphabet.indexOf(keyChar)

        if (messageCharIndex != -1) {
            val encryptedCharIndex = (messageCharIndex + keyCharIndex) % alphabet.length
            val encryptedChar = alphabet[encryptedCharIndex]
            encryptedMessage.append(encryptedChar)
        } else {
            encryptedMessage.append(messageChar)
        }
    }

    return encryptedMessage.toString()
}
