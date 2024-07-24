package com.invictus.starter.ui.recycler_utils

import com.invictus.starter.domain.model.MailModel

/**
 *
 * @param type must be unique for each type of item
 * @param id must be unique for each item
 * */
abstract class RModel(val type: Int, val id: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RModel

        if (type != other.type) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type
        result = 31 * result + id
        return result
    }
}


class Header(val name: String, id: Int) : RModel(0, id)

class Mail(val model: MailModel) : RModel(1, model.id)
