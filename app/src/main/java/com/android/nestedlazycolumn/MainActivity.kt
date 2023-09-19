package com.android.nestedlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    LazyColumn() {

        item { }

        items(200){
            Text(text = "This is Inner Nested")

            LazyColumn(){

                item {  }

                items(50) {
                    Text(text = "This is Inner inner Nested")
                }
            }

        }
    }
}

