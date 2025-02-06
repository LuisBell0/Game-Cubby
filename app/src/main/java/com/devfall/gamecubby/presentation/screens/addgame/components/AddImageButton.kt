package com.devfall.gamecubby.presentation.screens.addgame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devfall.gamecubby.presentation.screens.addgame.AddGameScreenViewModel
import org.koin.compose.viewmodel.koinViewModel

/*@Composable
fun AddImageButton() {

    var showImageDialog by remember { mutableStateOf(false) }

    ImageSourceDialog(
        getShowImageDialog = { showImageDialog },
        closeImageDialog = { showImageDialog = false }
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(115.dp)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .fillMaxHeight(),
            onClick = {
                showImageDialog = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            shape = MaterialTheme.shapes.small,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(text = "Add Image")
            }
        }
        viewModel.imageUri.value?.let { uri ->
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .width(115.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )
                IconButton(
                    onClick = { viewModel.imageUri.value = null },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(28.dp)
                        .background(MaterialTheme.colorScheme.error, shape = CircleShape)
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Delete Image",
                        tint = MaterialTheme.colorScheme.onError,
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddImageButton() {
    AddImageButton()
}*/


