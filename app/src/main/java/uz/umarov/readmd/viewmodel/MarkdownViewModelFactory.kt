package uz.umarov.readmd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.umarov.readmd.data.repository.GitHubRepository

class MarkdownViewModelFactory(private val repository: GitHubRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarkdownViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return MarkdownViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}