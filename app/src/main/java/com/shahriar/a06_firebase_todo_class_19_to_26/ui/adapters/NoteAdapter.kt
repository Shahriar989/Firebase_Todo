package com.shahriar.a06_firebase_todo_class_19_to_26.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shahriar.a06_firebase_todo_class_19_to_26.R
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.ui.viewholders.NoteViewHolder

class NoteAdapter(
    var context: Context,
    var noteList: List<Note>
) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = noteList[position]
        holder.title.text = item.noteText
        holder.description.text = item.priority
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}