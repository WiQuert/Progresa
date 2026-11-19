package com.wiquert.progresa.ui.student_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun StudentListScreen(
    modifier: Modifier = Modifier,
    viewModel: StudentListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is StudentListUiState.Loading -> {
            Box(modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is StudentListUiState.Success -> {
            if (state.students.isEmpty()) {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Учеников пока нет")
                }
            }
            else
            {
                LazyColumn(modifier = modifier.fillMaxSize()) {
                    items(state.students) {
                        student -> Text(student.name)
                    }
                }
            }
        }
        is StudentListUiState.Error   -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(state.message)
            }
        }
    }
}