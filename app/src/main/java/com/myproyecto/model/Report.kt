package com.myproyecto.model

import java.time.LocalDateTime
class Report(var id : String ,
                 var title : String ,
                 var description : String ,
                 var state : ReportState ,
                 var image : List<String> ,
                 var location : Location ,
             var fecha : LocalDateTime,

    ) {
}