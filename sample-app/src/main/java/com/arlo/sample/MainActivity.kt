package com.arlo.sample

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
import com.arlo.sample.ui.theme.ArloSampleTheme
import com.arlo.sdk.ArloSDK
import com.arlo.sdk.ui.ArloStatusCard
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArloSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArloSampleScreen()
                }
            }
        }
    }
}

@Composable
fun ArloSampleScreen() {
    var statusText by remember { mutableStateOf("SDK Ready") }
    var isLearning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Arlo SDK Sample",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "SDK Version: ${ArloSDK.getVersion()}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Use SDK's pre-built UI component
        ArloStatusCard(
            title = "SDK Status",
            status = statusText,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Learning Control
        Button(
            onClick = {
                if (isLearning) {
                    ArloSDK.stopLearning()
                    isLearning = false
                    statusText = "Learning stopped"
                } else {
                    ArloSDK.startLearning()
                    isLearning = true
                    statusText = "Learning started - analyzing behavior..."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isLearning) "Stop Learning" else "Start Learning")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Organize Apps
        OutlinedButton(
            onClick = {
                scope.launch {
                    statusText = "Organizing apps..."
                    val result = ArloSDK.organizeApps()
                    statusText = if (result.isSuccess) {
                        "Apps organized successfully"
                    } else {
                        "Error organizing apps: ${result.exceptionOrNull()?.message}"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Organize Apps")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Organize Photos
        OutlinedButton(
            onClick = {
                scope.launch {
                    statusText = "Organizing photos..."
                    val result = ArloSDK.organizePhotos()
                    statusText = if (result.isSuccess) {
                        "Photos organized successfully"
                    } else {
                        "Error organizing photos: ${result.exceptionOrNull()?.message}"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Organize Photos")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // SDK Info
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Integration Example",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This sample demonstrates how to integrate and use the Arlo SDK in your Android application.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}
