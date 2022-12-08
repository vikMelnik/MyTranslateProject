package com.example.mytranslateproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// Так как мы пишем на Kotlin, то достаточно написать поля в конструкторе
// класса. В качестве основной ячейки мы используем ячейку "слово", то есть
// слово, которое мы искали и хотим сохранить. unique = true означает, что
// в БД не будут сохраняться повторяющиеся слова.
@Entity(indices = arrayOf(Index(value = arrayOf("word"), unique = true)))
class HistoryEntity(
    @field:PrimaryKey
    @field:ColumnInfo(name = "word")
    var word: String, @field:ColumnInfo(name = "description")
    var description: String?
)
