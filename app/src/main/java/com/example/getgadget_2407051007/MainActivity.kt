package com.example.getgadget_2407051007
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
            GetGadgetApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetGadgetApp() {

    val listPhone = HandphoneSource.dummyHandphone

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Get Gadget", fontWeight = FontWeight.Bold)
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))
        ) {

            item {
                Text(
                    text = "Rekomendasi Populer",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(listPhone) { phone ->
                        PopularCard(phone)
                    }
                }
            }

            item {
                Text(
                    text = "Daftar Menu Lengkap",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            items(listPhone) { phone ->
                MenuCard(phone)
            }
        }
    }
}

@Composable
fun PopularCard(phone: Handphone) {

    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(end = 12.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box {

            Image(
                painter = painterResource(id = phone.imageRes),
                contentDescription = phone.nama,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color(0x99000000))
                    .padding(8.dp)
            ) {
                Text(phone.nama, color = Color.White, fontWeight = FontWeight.Bold)
                Text(phone.harga, color = Color.LightGray, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun MenuCard(phone: Handphone) {

    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Box {

            Image(
                painter = painterResource(id = phone.imageRes),
                contentDescription = phone.nama,
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth(),
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
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(Color(0xCC000000))
                    .padding(16.dp)
            ) {
                Text(phone.nama, color = Color.White, fontWeight = FontWeight.Bold)
                Text(phone.merk, color = Color.LightGray)
                Text("Harga: ${phone.harga}", color = Color.White)

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Pesan Sekarang")
                }
            }
        }
    }
}