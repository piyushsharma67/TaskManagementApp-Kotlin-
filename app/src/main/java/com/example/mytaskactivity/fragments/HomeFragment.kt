package com.example.mytaskactivity.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytaskactivity.MainApplicationClass
import com.example.mytaskactivity.R
import com.example.mytaskactivity.databinding.FragmentHomeBinding
import com.example.mytaskactivity.dbInstance.entities.Task

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
    lateinit var _binding: FragmentHomeBinding


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


        val adapter=TaskListAdapter()
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.fetchTasks().collect(){
                    Log.d("task",it.toString())
                    if(it.size==0){
                        Log.d("task","i am called")
                        adapter.submitList(listOf(Task(id = null, task = "no available task", time = "")))
                    }else{
                        adapter.submitList(it)
                    }
                }
            }
        }

        _binding.recyclerView.layoutManager=LinearLayoutManager(context)
        _binding.recyclerView.hasFixedSize()
        _binding.recyclerView.adapter=adapter

        _binding.fab.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
    }

}