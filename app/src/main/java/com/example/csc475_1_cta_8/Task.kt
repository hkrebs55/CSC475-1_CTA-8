package com.example.csc475_1_cta_8

import java.util.UUID

data class Task(var date: String, var taskName: String, var taskDescription: String, var completed: Boolean, val id: UUID) {
    override fun toString(): String {
        return "Task: date=$date, taskName=$taskName, taskDescription=$taskDescription, completed=$completed, id=$id"
    }
}