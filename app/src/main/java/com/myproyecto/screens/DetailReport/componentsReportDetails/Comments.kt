package com.myproyecto.screens.DetailReport.componentsReportDetails


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Send
@OptIn(ExperimentalMaterial3Api :: class)
@Composable
fun Comments (
    state: SheetState,
     dismissModalsheet: () -> Unit
){
    ModalBottomSheet(
       sheetState = state,
        onDismissRequest = dismissModalsheet

    ){
        Column (

            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            ListItem(
                headlineContent = {
                    Text(text = "Nombre persona")
                },
                supportingContent = {
                    Text(text =  "comçemtario de la persona")
                },
                leadingContent = {
                    Icon(
                        modifier =  Modifier.width(70.dp) .height(70.dp),
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Persona"
                    )
                }

            )

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy (10.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Row {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = "",
                        onValueChange = {}
                    )
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(

                            imageVector = Icons.Default.Send,
                            contentDescription = "Comentar"
                        )

                    }

                }


            }



        }

    }
}