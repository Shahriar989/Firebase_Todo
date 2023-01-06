package com.shahriar.a06_firebase_todo_class_19_to_26.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahriar.a06_firebase_todo_class_19_to_26.R
import com.shahriar.a06_firebase_todo_class_19_to_26.databinding.FragmentCreateTaskBinding
import com.shahriar.a06_firebase_todo_class_19_to_26.databinding.FragmentNoteShowDetailsBinding

class CreateTaskFragment : Fragment() {

    lateinit var binding: FragmentCreateTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}