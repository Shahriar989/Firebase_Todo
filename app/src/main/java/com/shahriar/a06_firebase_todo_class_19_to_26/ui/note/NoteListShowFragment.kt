package com.shahriar.a06_firebase_todo_class_19_to_26.ui.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shahriar.a06_firebase_todo_class_19_to_26.R
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.databinding.FragmentNoteListShowBinding
import com.shahriar.a06_firebase_todo_class_19_to_26.ui.adapters.NoteAdapter
import com.shahriar.a06_firebase_todo_class_19_to_26.ui.task.TaskViewModel
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListShowFragment : Fragment() {

    lateinit var binding: FragmentNoteListShowBinding

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentNoteListShowBinding.inflate(inflater, container, false)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllTaskData()
        viewModel.allTask.observe(viewLifecycleOwner){

            when(it){
                is UiState.Failure -> {
                    Log.i("TAG", "Failure: ${it.message}")
                }
                is UiState.Loading -> {

                    Log.i("TAG", "Loading.....")
                }
                is UiState.Success -> {

                    val data: List<Note> = it.data!!

                    Log.i("TAG", "onViewCreated: $data")
                    
                    setRecyclerView(data)
                }
            }
        }

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_noteListShowFragment_to_createTaskFragment)
        }
    }
    private fun setRecyclerView(data: List<Note>) {

        val noteAdapter = NoteAdapter(requireActivity(), data)
        binding.noteListRecyclerView.adapter = noteAdapter
        binding.noteListRecyclerView.setHasFixedSize(true)
    }
}