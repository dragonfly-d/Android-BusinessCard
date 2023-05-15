package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
                color = Color(0xFFd2e8d5)
            )
            .fillMaxSize()
    ) {
        CardImageTitle(
            stringResource(R.string.full_name),
            stringResource(R.string.title)
        )
    }
    ContactInfo(
        phone = stringResource(R.string.phone),
        share = stringResource(R.string.share),
        email = stringResource(R.string.email),
    )
}

@Composable
fun CardImageTitle(fullName: String, title: String) {
    val iconBgColor = 0xFF073042
    val titleColor = 0xFF006a35
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val imageLogo = painterResource(id = R.drawable.android_logo)
        Image(
            painter = imageLogo,
            contentDescription = null,
            Modifier
                .width(100.dp)
                .background(
                    Color(iconBgColor)
                )
        )
        Text(
            text = fullName,
            fontSize = 40.sp,
        )
        Text(
            text = title,
            color = Color(titleColor),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ContactInfo(phone: String, share: String, email: String){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(
                start = 90.dp,
                bottom = 40.dp
            ),
    ) {
        ContactItem(icon = Icons.Default.Phone, text = phone)
        ContactItem(icon = Icons.Default.Share, text = share)
        ContactItem(icon = Icons.Default.Email, text = email)
    }
}

@Composable
fun ContactItem(icon: ImageVector, iconColor: Long = 0xFF006a35, text: String) {
    Row(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(iconColor)
        )
        Text(
            text = text,
            Modifier.padding(start = 15.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}