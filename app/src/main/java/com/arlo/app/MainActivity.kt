package com.arlo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arlo.app.ui.theme.ArloTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArloTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArloHomeScreen()
                }
            }
        }
    }
}

@Composable
fun ArloHomeScreen() {
    var statusText by remember { mutableStateOf("Arlo AI is ready") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Arlo",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "AI-Powered Personal Assistant",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(48.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Status",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = statusText,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { statusText = "Learning your behavior patterns..." },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Learning")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { statusText = "Organizing apps and files..." },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Organize")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { statusText = "Managing photos..." },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Manage Photos")
        }
    }
}
