package ru.skillbranch.dev_intensive.extensions

import ru.skillbranch.dev_intensive.models.User
import ru.skillbranch.dev_intensive.models.UserView
import ru.skillbranch.dev_intensive.utils.Utils
import java.util.*

fun User.toUserView() : UserView {

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials (firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "Online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickname,
        initials = initials,
        status = status
    )




}


