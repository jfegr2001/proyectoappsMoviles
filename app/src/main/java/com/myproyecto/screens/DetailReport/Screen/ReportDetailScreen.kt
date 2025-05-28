package com.myproyecto.screens.DetailReport.Screen



import MapDetails
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.myproyecto.components.BackgroundImage
import com.myproyecto.screens.DetailReport.componentsReportDetails.Comments
import com.myproyecto.screens.DetailReport.componentsReportDetails.ItemDetailRreport
import com.myproyecto.screens.DetailReport.componentsReportDetails.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportDetailScreen(Id: String,
onNavigateBack: () -> Unit
) {

var lista = listOf<String>(
    "https://upload.wikimedia.org/wikipedia/commons/9/90/Armenia%2C_Quindio%2C_Colombia_-_panoramio_-_Jimmy_G%C3%B3mez_N_%2815%29.jpg",
"https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Valle_de_Cocora%2C_Colombia_03.jpg/1200px-Valle_de_Cocora%2C_Colombia_03.jpg",
    "https://upload.wikimedia.org/wikipedia/commons/9/90/Armenia%2C_Quindio%2C_Colombia_-_panoramio_-_Jimmy_G%C3%B3mez_N_%2815%29.jpg"
)
    var showComments by remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState(  skipPartiallyExpanded = true)

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()

        Scaffold (

            containerColor = Color.Transparent,

            topBar = {
                TopBar(Id = Id , onNavigateBack)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                        showComments = true


                    }
                )
                {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.Comment,
                        contentDescription = "Comentario"
                    )

                }
            }

        ){ padding ->

            Column (

                modifier =  Modifier
                    .padding(padding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp)

            ) {



                val state = rememberCarouselState {lista.count()}

                HorizontalUncontainedCarousel(
                    state = state,
                    modifier = Modifier . width(412.dp).height(220.dp),
                    itemSpacing = 186.dp,
                    itemWidth = 8.dp,
                    contentPadding = PaddingValues(horizontal = 16.dp)

                ) { i ->

                    val item = lista[i]

                    ElevatedCard (){
                        AsyncImage(
                            modifier = Modifier.fillMaxWidth()
                                .height(250.dp),
                            model = item,
                            contentDescription = "Imagen del reporte",
                            contentScale =  ContentScale.Fit ,
                        )

                    }



                }
                ItemDetailRreport(

                    icon = Icons.Default.Info,
                    texto = "Descripcion del reporte",
                )
                ItemDetailRreport(
                    icon = Icons.Default.Person,
                    texto = " Persona que publica",
                )
                ItemDetailRreport(
                    icon = Icons.Default.CalendarToday,
                    texto = "Fecha del reporte",
                )
                ItemDetailRreport(
                    icon = Icons.Default.Sell,
                    texto = "Categoria",
                )
                MapDetails(
                    onNavigateToDetail = {
                        // Puedes navegar o hacer log según sea necesario
                        Log.d("MAP", "Navegar al detalle con ID $it")
                    }
                )
            }




            if (showComments) {
                Comments(
                    state = sheetState,
                    dismissModalsheet = {
                        showComments = false
                    }
                )
            }

        }

    }



    }




//AsyncImage(
//modifier = Modifier.fillMaxWidth()
//.height(250.dp),
//model = "https://upload.wikimedia.org/wikipedia/commons/9/90/Armenia%2C_Quindio%2C_Colombia_-_panoramio_-_Jimmy_G%C3%B3mez_N_%2815%29.jpg",
//contentDescription = "Imagen del reporte"
//
//)
