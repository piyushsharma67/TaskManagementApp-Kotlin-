package com.example.mytaskactivity.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytaskactivity.MainApplicationClass
import com.example.mytaskactivity.R
import com.example.mytaskactivity.databinding.FragmentHomeBinding
import com.example.mytaskactivity.listAdapter.TaskListAdapter
import com.example.mytaskactivity.mainActivityViewModel.MainActivityViewModel
import com.example.mytaskactivity.mainActivityViewModel.MainActivityViewModelFactory
import com.example.mytaskactivity.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeFragment : Fragment() {

    lateinit var repository: TaskRepository
    lateinit var viewModel: MainActivityViewModel
    lateinit var _binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        repository=(activity?.application as MainApplicationClass).taskRepository
        viewModel=ViewModelProvider(this,MainActivityViewModelFactory(repository)).get(MainActivityViewModel::class.java)
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.button.setOnClickListener {
             val task=_binding.editTextTextMultiLine.text.toString()
            if(task==""){
                Toast.makeText(context,"task cannot be empty",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.savetaskDb(_binding.editTextTextMultiLine.text.toString())
            }

        }

        val adapter=TaskListAdapter()
         lifecycle.coroutineScope.launch{
             viewModel.fetchTasks().collect(){
                 adapter.submitList(it)
             }
         }

        _binding.recyclerView.layoutManager=LinearLayoutManager(context)
        _binding.recyclerView.hasFixedSize()
        _binding.recyclerView.adapter=adapter
    }

}