package com.example.getgadget_2407051007

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.getgadget_2407051007.model.Handphone
import com.example.getgadget_2407051007.model.HandphoneSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetPhoneApp()
        }
    }
}

@Composable
fun GetPhoneApp() {

    val listPhone = HandphoneSource.dummyHandphone

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "GET GADGET",
                color = Color.Red,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Daftar Handphone Terbaru",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(listPhone) { phone ->
            PhoneCard(phone)
        }
    }
}

@Composable
fun PhoneCard(phone: Handphone) {

    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A))
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Box {

                Image(
                    painter = painterResource(id = phone.imageRes),
                    contentDescription = phone.nama,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = if (isFavorite)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = phone.nama,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = phone.merk,
                color = Color.LightGray
            )

            Text(
                text = phone.harga,
                color = Color.Green,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Detail")
            }
        }
    }
}