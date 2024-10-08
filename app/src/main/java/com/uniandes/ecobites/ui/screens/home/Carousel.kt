import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uniandes.ecobites.R

@ExperimentalMaterial3Api
@Composable
fun OfferCarousel() {
    // List of images to be shown in the carousel
    val items = listOf(
        R.drawable.percent,
        R.drawable.free_delivery,
        R.drawable.two_for_one,
        R.drawable.fiftyoff
    )

    // Remember Carousel State
    val carouselState = rememberCarouselState { items.size }

    // Carousel implementation using Hero Strategy
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier.height(250.dp).fillMaxWidth(),
        preferredItemWidth = 250.dp,
        itemSpacing = 8.dp,
//        contentPadding = PaddingValues(horizontal = 40.dp)
    ) { index ->
        // Content of each carousel item
        Image(
            painter = painterResource(id = items[index]),
            contentDescription = "Carousel Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp).maskClip(MaterialTheme.shapes.extraLarge)
        )
    }
}
