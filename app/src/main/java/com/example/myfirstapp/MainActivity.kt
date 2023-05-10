package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpUI()
        }
    }
}

@Composable
fun SignUpUI() {

    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
            painter = painterResource(id = R.drawable.signing_up),
            contentDescription = null ,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "Create Accuont",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            modifier = Modifier.padding(start = 75.dp, top = 150.dp),
        )

        val firstName = remember { mutableStateOf("") }
        val lastName = remember { mutableStateOf("") }

        OutlinedTextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(start = 58.dp, top = 270.dp),
            textStyle = TextStyle(Color.Black),
            label = {
                Text(text = "First Name", color = Color.DarkGray)
            },
            singleLine = true,
            placeholder = { Text(text = "type your name ...")},
        )
        OutlinedTextField(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(start = 58.dp, top =  350.dp),
            textStyle = TextStyle(Color.Black),
            label = {
                Text(text = "Last Name", color = Color.DarkGray)
            },
            singleLine = true,
            placeholder = { Text(text = "type your FamilyName ...")},
        )

        val acceptEULA = remember { mutableStateOf(false) }

        Row {
            Checkbox(
                checked = acceptEULA.value,
                onCheckedChange = { acceptEULA.value = it },
                modifier = Modifier.padding(start = 90.dp , top = 437.dp)
            )
            Text(text = "I Accept Your EULA",
                modifier = Modifier.padding(top = 450.dp),
                fontWeight = FontWeight.Medium
            )

        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier.padding(start = 145.dp, top = 500.dp)
                .height(50.dp)
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    SignUpUI()
}

