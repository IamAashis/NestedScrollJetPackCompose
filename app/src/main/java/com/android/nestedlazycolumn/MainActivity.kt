package com.android.nestedlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.nestedlazycolumn.ui.theme.NestedLazyColumnTheme

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

        item { /* Content for the header */ }

        items(categories.size) { index ->
            Text(text = categories[index].title)

            categories[index].products.forEach {
                Text(text = it.name + ".........." + it.price)
            }

            /*repeat(10) { index ->
                // Code to be executed for each iteration
                Text(text = "This is Inner Nested")
            }*/

        }
    }
}

