package ru.netology.nmedia.util

import android.annotation.SuppressLint
import ru.netology.nmedia.data.Post
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor

object Service {

    private val likedPostsRepo: MutableMap<Long, MutableSet<Long>> = mutableMapOf()
    private val repostCounter: MutableList<Long> = mutableListOf()

    private val user = User(
        userId = 1L,
        userName = "Random User"
    )

    fun repost(postId: Long) = repostCounter.add(postId)
    fun repostCount(postId: Long) = repostCounter.filter { it == postId }.size

    fun fillPostFavoriteList(postId: Long): Boolean {
        likedPostsRepo[postId] = mutableSetOf()
        return likedPostsRepo.containsKey(postId)
    }



    fun likeCounter(postId: Long): Int {
       println("ID $postId")
       return likedPostsRepo[postId]!!.size
    }

    fun addPostToFavoritesList(postId: Long) =
        if (!likedPostsRepo[postId]!!.contains(user.userId)) {
            likedPostsRepo[postId]!!.add(user.userId)
        } else {
            likedPostsRepo[postId]!!.remove(user.userId)
        }

    @SuppressLint("SimpleDateFormat")
    fun Post.getSimpleDateFormat(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm").format(Date())
    }

    fun peopleCounter(quantity: Int): String {
        return when (quantity) {
            in 1..999 -> quantity.toString()
            in 1000..9999 -> {
                if (floor(quantity.toDouble() / 100) % 10 == 0.0) {
                    String.format("%.0f", quantity.toDouble() / 1000).plus("k")
                } else {
                    String.format("%.1f", quantity.toDouble() / 1000).plus("k")
                }
            }
            in 10000..999999 -> String.format("%.0f", floor(quantity.toDouble() / 1000)).plus("k")
            in 1000000..Int.MAX_VALUE -> {
                if (floor(quantity.toDouble() / 100000) % 10 == 0.0) {
                    String.format("%.0f", quantity.toDouble() / 1000000).plus("M")
                } else {
                    String.format("%.1f", quantity.toDouble() / 1000000).plus("M")
                }
            }
            else -> ""
        }
    }

    fun getId(): Long {
        var counter = 0L
        return ++counter
    }


    val longText: String = "Трогательным ножичком пытать свою плоть\n" +
            "Трогательным ножичком пытать свою плоть\n" +
            "До крови прищемить добровольные пальцы\n" +
            "Отважно смакуя леденцы на палочке\n" +
            "Целеустремлённо набивать карманы\n" +
            "Мёртвыми мышатами,живыми хуями\n" +
            "Шоколадными конфетами \n" +
            "И нерукотворными пиздюлями\n" +
            "На патриархальной свалке устаревших понятий\n" +
            "Использованных образов и вежливых слов\n" +
            "Покончив с собою,уничтожить весь мир\n" +
            "ПОКОНЧИВ С СОБОЮ-УНИЧТОЖИТЬ ВЕСЬ МИР!!\n" +
            "\n" +
            "        ...вечность пахнет нефтью\n" +
            "        ...вечность пахнет нефтью\n" +
            "\n" +
            "Словно иней,сердобольный смех\n" +
            "Словно иней,сердобольный смех\n" +
            "Словно иней,сердобольный смех\n" +
            "Славно валится на...\n" +
            "                 на...\n" +
            "                 на РУССКОЕ ПОЛЕ ЭКСПЕРИМЕНТОВ\n" +
            "\n" +
            "География подлости\n" +
            "Орфография ненависти\n" +
            "Апология невежества\n" +
            "Мифология оптимизма\n" +
            "Законы гаубицы благонравия\n" +
            "Знатное пиршество благоразумия\n" +
            "Устами ребенка глаголет яма\n" +
            "Устами ребенка глаголет пуля\n" +
            "\n" +
            "         ...вечность пахнет нефтью\n" +
            "         ...вечность пахнет нефтью\n" +
            "\n" +
            "Мастерство быть излишним,подобно мне\n" +
            "Мастерство быть любимым,подобно петле\n" +
            "Мастерство быть глобальным,как печёное яблоко\n" +
            "Искусство вовремя уйти в сторонку\n" +
            "   Искусство быть посторонним\n" +
            "   Искусство быть посторонним\n" +
            "Новейшее средство для очистки духовок\n" +
            "От задохнувшихся по собственной воле\n" +
            "Новейшее средство для очистки верёвок\n" +
            "От скверного запаха немытых  шей\n" +
            "   Новейшее средство находить виновных\n" +
            "   Новейшее средство находить виновных\n" +
            "\n" +
            "         РУССКОЕ ПОЛЕ ЭКСПЕРИМЕНТОВ\n" +
            "\n" +
            "За открывшейся дверью — пустота\n" +
            "Это значит,что кто-то пришёл за тобой\n" +
            "Это значит,что теперь ты кому-то                         \n" +
            "Понадобился\n" +
            "\n" +
            "А снег всё идёт,а снег всё идёт\n" +
            "Русское поле источает снег\n" +
            "\n" +
            "Иных хоронили в упаковке глазёнок\n" +
            "Иных хоронили в упаковке газет\n" +
            "\n" +
            "А то,что на бойне умертвили бычка \n" +
            "На то всеобщая радость,всеобщая гордость\n" +
            "Всеобщая ненависть,всеобщая воля\n" +
            "Всеобщая воля да всеобщая старость\n" +
            "\n" +
            "Набить до отказа собой могилу \n" +
            "Это значит наследовать землю\n" +
            "Что же такое наследовать землю\n" +
            "Это значит исчерпать терпение\n" +
            "   Что и требовалось доказать\n" +
            "   Что и требовалось доказать\n" +
            "\n" +
            "В дверной глазок — в замочную щель \n" +
            "Гениальные мыслишки — мировые войнушки\n" +
            "Неофициальные пупы земли\n" +
            "Эмалированные части головных систем\n" +
            "Инстинктивные добровольцы\n" +
            "Во имя вселенной и хлебной корочки\n" +
            "Люди с большой буквы\n" +
            "Слово «люди» пишется с большой буквы\n" +
            "\n" +
            "Свастика веры стянула лица\n" +
            "Вавилонская азбука налипла на пальцах\n" +
            "Исторически оправданный метод\n" +
            "Пожирания сырой земли\n" +
            "   Это ли не то,что нам надо?!\n" +
            "   Это ли не то,что нам надо?!\n" +
            "\n" +
            "А поутру они неизбежно проснулись\n" +
            "Не простудились — не замарались\n" +
            "Называли вещи своими именами\n" +
            "Сеяли доброе,разумное,вечное\n" +
            "Всё посеяли,всё назвали\n" +
            "Кушать подано — честь по чести\n" +
            "На первое были плоды просвещения\n" +
            "А на второе — кровавые мальчики\n" +
            "\n" +
            "Орденоносный господь победоносного мира\n" +
            "Заслуженный господь краснознамённого страха\n" +
            "Праведный праздник для правильных граждан\n" +
            "Отточенный серп для созревших колосьев\n" +
            "\n" +
            "Яма как принцип движения к Солнцу\n" +
            "Кашу слезами не испортишь нет\n" +
            "\n" +
            "Полные сани девичьим срамом\n" +
            "Полные простыни ребячьим смрадом\n" +
            "Девичьи глазки,кукушкины слёзки\n" +
            "А так же всякие иные предметы\n" +
            "\n" +
            "Так кто погиб в генеральном сраженьи\n" +
            "Кто погиб в гениальном поражении\n" +
            "За полную чашку жалости\n" +
            "В Сталинградской битве озверевшей похоти?\n" +
            "\n" +
            "Самолёт усмехнулся вдребезги\n" +
            "В бугорок обетованной земли\n" +
            "Самолёт усмехнулся вдребезги\n" +
            "В бугорок обетованной землицы\n" +
            "\n" +
            "А свою любовь я собственноручно\n" +
            "Освободил от дальнейших неизбежных огорчений\n" +
            "Подманил ее пряником\n" +
            "Подманил ее пряником  \n" +
            "Изнасиловал пьяным жестоким ботинком\n" +
            "И повесил на облачке,словно ребёнок\n" +
            "        СВОЮ НЕЛЮБИМУЮ КУКЛУ\n" +
            "        СВОЮ НЕЛЮБИМУЮ КУКЛУ\n" +
            "        СВОЮ НЕЛЮБИМУЮ КУКЛУ\n" +
            "        СВОЮ НЕЛЮБИМУЮ КУКЛУ\n" +
            "\n" +
            "Словно иней,сердобольный смех \n" +
            "Словно иней,сердобольный смех \n" +
            "Словно иней,сердобольный смех \n" +
            "Словно иней,сердобольный смех \n" +
            "Славно валиться на...\n" +
            "                 на...\n" +
            "                 на РУССКОЕ ПОЛЕ ЭКСПЕРИМЕНТОВ\n" +
            " \n" +
            "       Вечность пахнет нефтью"

}
