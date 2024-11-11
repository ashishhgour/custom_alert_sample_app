package com.example.sampleapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customalertdialog.CustomAlertDialog

@Composable
fun MainScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var actionResult by remember { mutableStateOf("") }

    // Simulate cart item data
    val cartItemName = "Wireless Headphones"

    // Create an instance of CustomAlertDialog
    val deleteItemDialog = CustomAlertDialog.Builder()
        .setTitle("Remove Item")
        .setMessage("Are you sure you want to remove $cartItemName from your cart?")
        .addButton("Remove") {
            actionResult = "$cartItemName has been removed from your cart."
            showDialog = false
        }
        .addButton("Cancel") {
            actionResult = "Action canceled."
            showDialog = false
        }
        .build()

    // Main screen layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Cart",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = cartItemName,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Remove from Cart")
        }

        Text(
            text = actionResult,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Show the custom alert dialog if `showDialog` is true
        if (showDialog) {
            deleteItemDialog.ShowDialog(onDismiss = { showDialog = false })
        }
    }
}