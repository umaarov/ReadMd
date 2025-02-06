package uz.umarov.readmd

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.noties.markwon.Markwon
import kotlinx.coroutines.launch
import uz.umarov.readmd.data.remote.RetrofitInstance
import uz.umarov.readmd.data.repository.GitHubRepository
import uz.umarov.readmd.databinding.ActivityMainBinding
import uz.umarov.readmd.viewmodel.MarkdownViewModel
import uz.umarov.readmd.viewmodel.MarkdownViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MarkdownViewModel by viewModels {
        MarkdownViewModelFactory(GitHubRepository(RetrofitInstance.api))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val markwon = Markwon.create(this)

        lifecycleScope.launch {
            viewModel.markdownContent.collect { markdown ->
                markwon.setMarkdown(binding.markdownTextView, markdown)
            }
        }

        viewModel.loadMarkdown()
    }
}