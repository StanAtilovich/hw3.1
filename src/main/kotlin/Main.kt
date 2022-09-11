val day = (60 * 60) * 24
val hour = 60 * 60
val min = 60


fun hour(hou: Int) = when (hou) {
    1, 21 -> "час"
    2, 3, 4, 22, 23, 24 -> "часа"
    else -> "часов"
}

fun min(mins: Int) = when (mins) {
    1, 21, 31, 41, 51 -> "минуту"
    2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
    else -> "минут"
}

fun whenTheyBeen(time: Int): String {
    val text: String = when {
        time in 1..60 -> "только что"
        time in min..hour -> "${time / 60} ${min(time / 60)} назад"
        time >= hour + 1 && time <= day -> "${time / (60 * 60)} ${hour(time / (60 * 60))} назад"
        time <= 2 * day && time > 1 * day -> "сегодня"
        time <= 3 * day && time > 2 * day -> "вчера"
        else -> "давно"
    }
    return text
}

fun main() {
    println("Был(а) в сети ${whenTheyBeen(60)}")
    println("Был(а) в сети ${whenTheyBeen(2 * min)}")
    println("Был(а) в сети ${whenTheyBeen(5 * min)}")
    println("Был(а) в сети ${whenTheyBeen(11 * min)}")
    println("Был(а) в сети ${whenTheyBeen(21 * min)}")
    println("Был(а) в сети ${whenTheyBeen(25 * min)}")
    println("Был(а) в сети ${whenTheyBeen(21 * hour)}")
    println("Был(а) в сети ${whenTheyBeen(3 * day)}")
    println("Был(а) в сети ${whenTheyBeen(2 * day)}")
    println("Был(а) в сети ${whenTheyBeen(8 * day)}")
}

