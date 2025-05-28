package com.myproyecto.model

import java.time.LocalDateTime

class Comment (

    var id: String,
    var content: String,
    var userId: User,
    var reportId: Report,
    var fecha : LocalDateTime





) {
}