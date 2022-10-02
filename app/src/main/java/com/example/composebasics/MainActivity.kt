package com.example.composebasics


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import kotlinx.coroutines.launch
import java.time.Duration


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android ");
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    val color = Color(0XFF897EFF);
    val email = remember { mutableStateOf(TextFieldValue())}
    val password = remember { mutableStateOf(TextFieldValue())}

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    )
    {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                Icons.Filled.DateRange, contentDescription = "Logo", modifier = Modifier
                    .height(50.dp)
                    .width(50.dp), tint = Color.Blue
            )
            Box(modifier = Modifier.width(10.dp))
            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
                )

        }

        Box(modifier = Modifier.height(10.dp))

        Text(
            text = "Sign in to continue",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Box(modifier = Modifier.height(30.dp))

        TextField(
            value = email.value,
            onValueChange = { email.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            label = { Text("Enter your email")},
            leadingIcon = {
                Icon(
                    Icons.Filled.Email, "email"
                )
            },
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                leadingIconColor = color.copy(
                    TextFieldDefaults.IconOpacity
                ),
                backgroundColor = Color.LightGray.copy(
                    TextFieldDefaults.BackgroundOpacity
                )
            ),

        )

        Box(modifier = Modifier.height(15.dp))

        TextField(
            value = password.value,
            onValueChange = { password.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            placeholder = { Text("Enter your password")},
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock, "password"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                leadingIconColor = color.copy(
                    TextFieldDefaults.IconOpacity
                ),
                backgroundColor = Color.LightGray.copy(
                    TextFieldDefaults.BackgroundOpacity
                )
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            )

        Box(modifier = Modifier.height(40.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = color
            )

        ) {
            Text("Login",
            fontWeight = FontWeight.Bold,
            color = Color.White,
                fontSize = 20.sp,

            )
        }

        Box(modifier = Modifier.height(20.dp))

        Text(
            "Forgot password?",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = color
        )

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}