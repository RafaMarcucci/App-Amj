package com.example.projetoamj3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoamj3.ui.theme.ProjetoAMJ3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoAMJ3Theme {
                // Aqui deve fechar corretamente o Scaffold
                Scaffold(
                    modifier = Modifier.fillMaxSize() // Corrigido para ter fechamento correto
                ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize()
        )

        // Conteúdo da tela
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), // Garantir que o conteúdo não sobreponha a borda
            verticalArrangement = Arrangement.Top, // Alinha os componentes ao topo
            horizontalAlignment = Alignment.CenterHorizontally // Centraliza os componentes horizontalmente
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Texto de boas-vindas
            Text(
                text = "Bem Vindo ao sistema\nGrupo AMJ Fire",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp)) // Espaço entre os componentes

            // Campo de email
            BasicTextField(
                value = "", // Controle do estado
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray) // Usando Modifier.background para adicionar a cor de fundo
                    .padding(20.dp),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                        innerTextField()
                        Text(text = "Email", color = Color.White)
                    }
                }
            )

            Spacer(modifier = Modifier.height(15.dp)) // Espaço entre os campos

            // Campo de senha
            BasicTextField(
                value = "", // Controle do estado
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray) // Usando Modifier.background para adicionar a cor de fundo
                    .padding(20.dp),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                        innerTextField()
                        Text(text = "Senha", color = Color.White)
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp)) // Espaço entre os campos

            // Texto para esqueci minha senha
            Text(
                text = "Esqueci minha senha",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 20.dp, top = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjetoAMJ3Theme {
        MainScreen(modifier = Modifier.fillMaxSize()) // Agora deve estar correto
    }
}
