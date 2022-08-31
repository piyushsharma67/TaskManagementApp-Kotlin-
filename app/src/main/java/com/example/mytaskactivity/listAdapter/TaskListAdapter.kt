package com.example.mytaskactivity.listAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskactivity.R
import com.example.mytaskactivity.dbInstance.entities.Task

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.ProgrammingViewHolderProvider>(DiffUtilClass()){

    class ProgrammingViewHolderProvider(view: View) : RecyclerView.ViewHolder(view){
       var task=view.findViewById<TextView>(R.id.task)

        fun bind(item: Task){
            task.text=item.task
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingViewHolderProvider {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.task_list_layout,parent,false)
        return ProgrammingViewHolderProvider(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolderProvider, position: Int) {
        val item=getItem(position)
        holder.bind(item)

    }
}

class DiffUtilClass : androidx.recyclerview.widget.DiffUtil.ItemCallback<Task>(){
    override fun areItemsTheSame(
        oldItem: Task,
        newItem: Task
    ): Boolean {
        return oldItem===newItem
    }

    override fun areContentsTheSame(
        oldItem: Task,
        newItem: Task
    ): Boolean {
        return oldItem.id===newItem.id
    }


}
