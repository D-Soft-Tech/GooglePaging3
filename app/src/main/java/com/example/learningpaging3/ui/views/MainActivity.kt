package com.example.learningpaging3.ui.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.learningpaging3.R
import com.example.learningpaging3.databinding.ActivityMainBinding
import com.example.learningpaging3.ui.adapters.RecyclerViewAdapter
import com.example.learningpaging3.ui.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : AppCompatActivity() {
    @Inject
    lateinit var rvAdapter: RecyclerViewAdapter
    private val viewModel: AppViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()

        lifecycleScope.launchWhenCreated {
            viewModel.getAllRecords().collectLatest {
                rvAdapter.submitData(it)
            }
        }
    }

    private fun initViews() {
        recyclerView = binding.rv
        recyclerView.apply {
            addItemDecoration(
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            )
            adapter = rvAdapter
        }
    }
}
