

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState

@Composable
fun ReportMapPage() {

    var mapViewportState = rememberMapViewportState(){
        setCameraOptions {
            zoom(9.0)
            center(Point.fromLngLat(-75.6491181, 4.46878991))
        }
    }
    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = mapViewportState,


    )
}