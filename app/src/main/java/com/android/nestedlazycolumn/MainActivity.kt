package com.android.nestedlazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.nestedlazycolumn.ui.theme.NestedLazyColumnTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedLazyColumnTheme {
                // A surface container using the 'background' color from the theme
                NestedColumn()
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun NestedColumn() {

    val categories = listOf(
        Category(
            title = "Restaurant 1",
            products = listOf(
                Product(
                    name = "Momo",
                    quantity = 1,
                    price = 425
                ),
                Product(
                    name = "chomein",
                    quantity = 1,
                    price = 425
                )
            )
        ),
        Category(
            title = "Restaurant 2",
            products = listOf(
                Product(
                    name = "New Chicken",
                    quantity = 2,
                    price = 325
                )
            )
        )
    )

    LazyColumn {

        item { Text(text = "This is Header context") }

        items(categories.size) { index ->
            Text(text = categories[index].title)

            var selectedItem by remember { mutableStateOf<String?>(null) }
            var canClick by remember { mutableStateOf(true) }

            categories[index].products.forEach {
                Card(
                    modifier = Modifier.clickable {
                        if (canClick) {
                            canClick = false
                            selectedItem = it.name
                            Log.d("click", it.name)
                            // Delay for 10 seconds
                            GlobalScope.launch {
                                delay(2000)
                                selectedItem = null
                                canClick = true
                            }
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(50.dp)
                    ) {
                        Text(text = it.name + ".........." + it.price, fontSize = 17.sp)
                    }
                }

            }
            /*repeat(10) { index ->
                // Code to be executed for each iteration
                Text(text = "This is Inner Nested")
            }*/

        }
    }
}

