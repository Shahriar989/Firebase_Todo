package com.shahriar.a06_firebase_todo_class_19_to_26.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.databinding.FragmentCreateTaskBinding
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTaskFragment : Fragment() {

    lateinit var binding: FragmentCreateTaskBinding

    private val viewModel: TaskViewModel by viewModels()

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

        binding.submit.setOnClickListener {

            val task = binding.taskEt.text.toString()

            viewModel.addNote(Note("", task, "High", "" + System.currentTimeMillis()))
        }

        viewModel.createNoteResponse.observe(viewLifecycleOwner) {

            when (it) {
                is UiState.Failure -> {

                    Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                    binding.submit.visibility = View.VISIBLE
                }
                is UiState.Loading -> {

                    Toast.makeText(context, "Creating your note to DB", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.VISIBLE
                    binding.submit.visibility = View.INVISIBLE

                }
                is UiState.Success -> {

                    Toast.makeText(context, "Note to Db Success", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                    findNavController().popBackStack()
                }
            }
        }
    }
}


