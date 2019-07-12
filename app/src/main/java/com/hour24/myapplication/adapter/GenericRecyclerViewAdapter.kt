package com.hour24.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.*

@Suppress("UNCHECKED_CAST")
abstract class GenericRecyclerViewAdapter<T : Any, in D : ViewDataBinding>(
    private val mContext: Context,
    private val mLayoutId: Int,
    private var mList: ArrayList<T>
) : RecyclerView.Adapter<GenericRecyclerViewAdapter.ViewHolder>() {

    private val mRandom = Random()


    abstract fun onBindData(position: Int, model: T, dataBinding: D)

    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), mLayoutId, parent, false)
        return ViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            onBindData(position, mList[position], holder.mDataBinding as D)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return if (mList.isNullOrEmpty()) mList.size else 0
    }

    /**
     * addAll List
     */
    fun addAll(list: ArrayList<T>) {
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        mList.add(item)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T {
        return mList[position]
    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var mDataBinding: ViewDataBinding = binding
    }

//    mRecentAdapter = object : GenericRecyclerViewAdapter<Recent, MainRecentItemBinding>(this@MainActivity, R.layout.main_recent_item, mRecentList) {
//
//        override fun onBindData(position: Int, model: Recent?, dataBinding: MainRecentItemBinding?) {
//
//            try {
//
//                val viewModel = ViewModel()
//                viewModel.mModel = model
//                dataBinding!!.viewModel = viewModel
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }
//    }
}
