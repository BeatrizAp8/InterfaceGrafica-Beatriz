package com.example.interfacegrafica

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var MinhaViewModelQueEuCrieiAgoraPouco: MinhaViewBemSimples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MinhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewBemSimples::class.java)

        setContent {

              MainScreen(MinhaViewModelQueEuCrieiAgoraPouco)

        }
    }
}



@Composable
fun MinhaSaudacao(nome:String = "World", adj:String, modificador:Modifier){
    Text(text = "Hello $adj $nome !", modifier = modificador)
}





@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador
    )
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview() {


    }


@Composable
fun MainScreen(umaViewModel: MinhaViewBemSimples){
    var contadorNaView by remember {
        mutableStateOf(0)
    }
    val contadorProvenineteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()
    Column {
        Button(
            onClick = {
                contadorNaView += 1 //estudante
                umaViewModel.incrementaContador() //prof
                Log.i("##### NOSSO_LOG", "Valor do Contador = $contadorNaView")
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
                // Also contentColor and disabledContentColor
            ),

        ) {
            Text(text = "INCREMENTA CONTADOR")
        }

        Button(
            onClick = {
                contadorNaView -= 1
                umaViewModel.subtraiContador()
                Log.i("##### NOSSO_LOG", "Valor do Contador = $contadorNaView")
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
                // Also contentColor and disabledContentColor
            ),
        ) {
            Text(text = "SUBTRAI CONTADOR")
        }

        Text(text = "Valor do Contador (View)= $contadorNaView")
        Text(text = "Valor do Contador (ViewModel)= $contadorProvenineteDaMinhaModelView")

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Beatriz Aparecida Do Valle Martins")
        Text(text = "RM: 22383")
    }








     }

