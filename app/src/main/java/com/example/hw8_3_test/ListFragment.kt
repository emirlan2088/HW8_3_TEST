package com.example.hw8_3_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNREACHABLE_CODE")
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)

        val recyclerView =
            view?.findViewById<RecyclerView>(R.id.recyclerView)
        if (recyclerView != null) {
            recyclerView.layoutManager = error(requireContext())
        }
        if (recyclerView != null) {
            recyclerView.adapter = MyAdapter {  item ->
                findNavController().navigate(R.id.action_listFragment_to_detailFragment)
            }
        }
        return view
        }
    }

    class MyAdapter(private val clickListener: (String) -> Unit) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        private val items = listOf("Item 1", "Item 2", "Item 3")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                android.R.layout.simple_list_item_1,
                parent, false
            )
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
            holder.bind(items[position], clickListener)
        }

        override fun getItemCount() = items.size

        class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            fun bind(item: String, clickListener: (String) -> Unit) {
                (itemView as TextView).text = item
                itemView.setOnClickListener { clickListener(item) }
            }
        }
    }
