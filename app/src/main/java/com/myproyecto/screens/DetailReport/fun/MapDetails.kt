
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage
import com.mapbox.maps.extension.compose.rememberMapState
import com.mapbox.maps.plugin.gestures.generated.GesturesSettings
import com.myproyecto.R

@Composable
fun MapDetails(onNavigateToDetail: (String) -> Unit) {
    val context = LocalContext.current

    val mapViewportState = rememberMapViewportState {
        setCameraOptions {
            zoom(9.0)
            center(Point.fromLngLat(-75.6491181, 4.46878991))
        }
    }

    val markerResourceId by remember {
        mutableStateOf(R.drawable.red_marker)
    }

    val marker = rememberIconImage(
        key = markerResourceId,
        painter = painterResource(markerResourceId)
    )

    MapboxMap(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        mapViewportState = mapViewportState,
        mapState = rememberMapState {
            gesturesSettings = GesturesSettings { pitchEnabled = false }
        }
    ) {
        PointAnnotation(
            point = Point.fromLngLat(-75.6491181, 4.46878991)
        ) {
            iconImage = marker
            interactionsState.onClicked {
                onNavigateToDetail("123")
                true
            }
        }
    }
}