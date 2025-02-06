package com.devfall.gamecubby.presentation.screens.addgame.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.devfall.gamecubby.presentation.screens.addgame.AddGameScreenViewModel
import java.io.File

/*
@Composable
fun ImageSourceDialog(
    getShowImageDialog: () -> Boolean,
    closeImageDialog: () -> Unit
) {

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.imageUri.value = uri
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success: Boolean ->
        if(!success) {
            viewModel.imageUri.value = null
        }
    }

    // Function to create a temporary file for the camera
    val context = LocalContext.current
    val createImageFile: () -> Uri = {
        val file = File.createTempFile("captured_image", ".jpg", context.cacheDir)
        FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
    }

    if (viewModel.showDialog.value) {
        AlertDialog(
            onDismissRequest = { viewModel.showDialog.value = false },
            title = { Text("Select Image Source") },
            confirmButton = { },
            dismissButton = {
                Column {
                    Text(
                        "Pick from Gallery",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                viewModel.showDialog.value = false
                                galleryLauncher.launch("image/*")
                            }
                    )
                    HorizontalDivider()
                    Text(
                        "Take a Photo",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                viewModel.showDialog.value = false
                                val imageUri = createImageFile()
                                viewModel.imageUri.value = imageUri
                                cameraLauncher.launch(imageUri)
                            }
                    )
                }
            }
        )
    }
}*/