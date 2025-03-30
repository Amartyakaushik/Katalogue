import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.katalogue.android.ui.productdetail.ProductDetailViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductDetailViewModel = hiltViewModel()) {
    LaunchedEffect(productId) {
        viewModel.getProductDetail(productId)
    }

    val product by viewModel.product.collectAsState(initial = null)

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        product?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    HorizontalPager(count = it.images.size) { page ->
                        Image(
                            painter = rememberAsyncImagePainter(model = it.images[page]),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                    }
                }
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, color = Color.White)
                )
                Text(
                    text = "$${it.price}",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )
                Text(
                    text = it.description,
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray)
                )
                Text(
                    text = "Category: ${it.category}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                )
                Text(
                    text = "Rating: ${it.rating}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                )
                Button(
                    onClick = { /* Add to cart logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Add to Cart", color = Color.White)
                }
            }
        } ?: CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}