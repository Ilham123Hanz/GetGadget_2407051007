package com.example.getgadget_2407051007
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.getgadget_2407051007.ui.theme.GetGadget_2407051007Theme
import com.tugas.getphone.model.HandphoneSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            GetGadget_2407051007Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val getphone = HandphoneSource.dummyHandphone[0]

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)){
        Text(text = "Nama: ${getphone.nama}")
        Text(text = "merk: ${getphone.merk}")
        Text(text = "Harga: Rp ${getphone.harga}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GetGadget_2407051007Theme() {
        Greeting()
    }
}