package com.invictus.starter.data.data_source

import com.invictus.starter.domain.model.MailModel

object FakeMailDataSource {

    private val mailList = mutableListOf(
        MailModel(
            name = "Alice Smith",
            subject = "Meeting Reminder",
            body = "Don't forget about our meeting tomorrow at 10 AM.",
            time = "10 AM",
            color = 0xFFE57373.toInt() // Light Red
        ),
        MailModel(
            name = "Bob Johnson",
            subject = "Project Update",
            body = "Here is the latest update on the project. Please review the attached document.",
            time = "2:30 PM",
            color = 0xFF64B5F6.toInt() // Light Blue
        ),
        MailModel(
            name = "Charlie Brown",
            subject = "Birthday Invitation",
            body = "You are invited to my birthday party this Saturday at 7 PM. Hope to see you there!",
            time = "4 PM",
            color = 0xFF81C784.toInt() // Light Green
        ),
        MailModel(
            name = "Diana Prince",
            subject = "New Job Opportunity",
            body = "We have an exciting new job opportunity that matches your profile. Let's discuss further.",
            time = "11:45 AM",
            color = 0xFFFFD54F.toInt() // Light Yellow
        ),
        MailModel(
            name = "Eve Adams",
            subject = "Thank You",
            body = "Thank you for your help with the recent project. Your assistance was invaluable.",
            time = "6:20 PM",
            color = 0xFFBA68C8.toInt() // Light Purple
        )
    )

    fun getAllMails(): List<MailModel> {
        return mailList
    }

    fun composeMail(mailModel: MailModel) {
        mailList.add(mailModel)
    }


}