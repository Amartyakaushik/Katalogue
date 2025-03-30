import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.katalogue.android.ui.productlist.ProductListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(viewModel: ProductListViewModel = hiltViewModel(), onProductClick: (Int) -> Unit) {
    val products by viewModel.products.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xB5F5F5F5)) // Light grayish background
    ){
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            // Search Bar
            TextField(
                value = "",
                onValueChange = { /* Handle search */ },
                placeholder = { Text("Search product", color = Color.Gray) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                shape = RoundedCornerShape(12.dp), // Rounded corners
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Header
            Text(
                text = "Products",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, color = Color.Black),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "${products.size} products found",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Product Grid
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(products) { product ->
                    ProductItem(product) {
                        onProductClick(product.id)
                    }
                }
            }
        }
    }
}
