package com.example.mytaskactivity.fragments.addtaskFragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mytaskactivity.MainApplicationClass
import com.example.mytaskactivity.R
import com.example.mytaskactivity.databinding.FragmentAddTaskBinding
import com.example.mytaskactivity.repository.TaskRepository

class AddTaskFragment : Fragment() {

    private lateinit var viewModel: AddTaskViewModel
    private lateinit var _binding:FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository:TaskRepository=(activity?.application as MainApplicationClass).taskRepository
        viewModel=ViewModelProvider(this,AddTaskViewModelFactory(repository)).get(AddTaskViewModel::class.java)
        _binding=FragmentAddTaskBinding.inflate(inflater,container,false)

        return _binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var am_pm=""
        var hour=0
        super.onActivityCreated(savedInstanceState)

        _binding.switch1.setOnCheckedChangeListener ({_,isChecked ->
            if(isChecked){
                _binding.timePicker.setIs24HourView(true)
            }else {
                _binding.timePicker.setIs24HourView(false)
            }

        })
        _binding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->

            when {hourOfDay == 0 -> {
                am_pm = "AM"
            }
                hourOfDay == 12 -> am_pm = "PM"
                hourOfDay > 12 -> {
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
        }

        _binding.submitt.setOnClickListener {
            _binding.time.setText(
                StringBuilder().append(_binding.timePicker.hour).append(":").append(_binding.timePicker.minute)
                    .append(" ").append(am_pm)
            )
            val task=_binding.editTextTextMultiLine2.text.toString()
            val time=_binding.time.text.toString()
            if(time!="" && task!=""){
                viewModel.savetask(task,time)

               view.findNavController().navigate(R.id.action_addTaskFragment_to_homeFragment)
            }
        }


    }
}