package com.example.dicerolleradmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerolleradmin.ui.theme.DiceRollerAdminTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAdminTheme {
                DiceRollerApp()
            }
        }
    }
}


@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    var result by  remember { mutableStateOf(1)}
    val image = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
         modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = image), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                result = (1..6).random()
            }
        ){
            Text(
                text = stringResource(R.string.roll_text)
            )
        }
    }
}