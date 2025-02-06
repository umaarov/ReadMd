package uz.umarov.readmd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.umarov.readmd.data.repository.GitHubRepository

class MarkdownViewModel(private val repository: GitHubRepository) : ViewModel() {
    private val _markdownContent = MutableStateFlow("Loading...")
    val markdownContent = _markdownContent.asStateFlow()

    fun loadMarkdown() {
        viewModelScope.launch {
            repository.fetchMarkdown().collect { markdown ->
                _markdownContent.value = markdown
            }
        }
    }
}