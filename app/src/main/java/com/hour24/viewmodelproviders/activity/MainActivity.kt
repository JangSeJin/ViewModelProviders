package com.hour24.viewmodelproviders.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hour24.viewmodelproviders.R
import com.hour24.viewmodelproviders.adapter.GenericRecyclerViewAdapter
import com.hour24.viewmodelproviders.databinding.MainActivityBinding
import com.hour24.viewmodelproviders.databinding.MainItemBinding
import com.hour24.viewmodelproviders.model.LanguageModel
import com.hour24.viewmodelproviders.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: MainActivityBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: GenericRecyclerViewAdapter<LanguageModel, MainItemBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        initViewModel()
        initLayout()

        mViewModel.getLanguageList()

    }

    private fun initViewModel() {

        mViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java).apply {

            mBinding.viewModel = this

            mList.observe(this@MainActivity, Observer {
                mAdapter.addAll(it)
            })

        }

    }

    private fun initLayout() {

        mAdapter = object :
            GenericRecyclerViewAdapter<LanguageModel, MainItemBinding>(
                this@MainActivity,
                R.layout.main_item
            ) {

            override fun onBindData(
                position: Int,
                model: LanguageModel,
                dataBinding: MainItemBinding
            ) {

                val viewModel =
                    ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
                viewModel.mModel = model
                dataBinding.viewModel = mViewModel

            }
        }

        mBinding.rvMain.adapter = mAdapter

    }


}
