package com.hour24.viewmodelproviders.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
abstract class GenericRecyclerViewAdapterV2<T : Any, D : ViewDataBinding>(
    private val mLayoutId: Int
) : RecyclerView.Adapter<GenericRecyclerViewAdapterV2.ViewHolder>() {

    abstract fun onBindData(position: Int, model: T, dataBinding: D)

    // List
    private var mList: ArrayList<T> = ArrayList()

    init {

    }

    override fun getItemCount(): Int {
        return if (mList.isNullOrEmpty()) mList.size else 0
    }

    fun addAll(list: List<T>) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val dataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                mLayoutId,
                parent,
                false
            )

        return ViewHolder(dataBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindData(position, mList[position], holder.mDataBinding as D)
    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var mDataBinding: ViewDataBinding = binding
    }
}
