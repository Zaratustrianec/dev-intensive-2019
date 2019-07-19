package ru.skillbranch.dev_intensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.dev_intensive.extensions.TimeUnits
import ru.skillbranch.dev_intensive.extensions.add
import ru.skillbranch.dev_intensive.extensions.format
import ru.skillbranch.dev_intensive.extensions.toUserView
import ru.skillbranch.dev_intensive.models.*
import ru.skillbranch.dev_intensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}


class User {
    @Test
    fun test_instance() {
//        val user = User("1")
//        val user2 = User("2", "John", "Cene")
//        val user3 = User("3", "John", "Silverhand",null, lastVisit = Date(), isOnline = true)
//
//        user.printMe()
//        user2.printMe()
//        user3.printMe()
//
//        println("$user $user2 $user3")
    }

    @Test
    fun test_factory() {
      /*  val user = User.makeUser("John Cena")
        val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("") */
        val user = User.makeUser("John Wick")
        val user2 = user.copy (id = "2", lastName = "Cene", lastVisit = Date())
        print ("$user \n$user2")

    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserinfo() = user

        val (id, firstName, lastName) = getUserinfo()
        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }


    @Test
    fun test_dopy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2 , TimeUnits.HOUR))

       /* if (user == user2) {
            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }else{
            println("not equals data and hash \n${user.hashCode()} $user \n${user2.hashCode()} $user2")
        }

        if (user === user2) {
           println("equals address ${System.identityHashCode(user)}  ${System.identityHashCode(user2)} ")
        }else {
            println("not equals address ${System.identityHashCode(user)}  ${System.identityHashCode(user2)} ")
        } */
        println("""
         ${user.lastVisit?.format()}
         ${user2.lastVisit?.format()}
         ${user3.lastVisit?.format()}
        """.trimIndent())
    }


    @Test
    fun test_data_maping(){
        val user = User.makeUser("Korolev Anton")
        println(user)

        val userView = user.toUserView()

        userView.printMe()
    }


    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Korolev Anton")
        val  txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type ="text")
        val  imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type ="image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
        /*when(txtMessage) {
            is BaseMessage -> println("this is base message")
            is TextMessage -> println("this is text message")
            is ImageMessage -> println("this is image message")
        }*/
    }

}
