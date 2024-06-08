package com.example.stockmanagement.ui.lighting

import EditDialogFragment
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.db.History
import com.example.stockmanagement.db.HistoryDao
//import com.example.stockmanagement.db.History
//import com.example.stockmanagement.db.HistoryDao

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DashboardAdapterL(
   private val context: Context,
   private val historyList: List<History>,
   private val historyDao: HistoryDao
) :
   RecyclerView.Adapter<DashboardAdapterL.ViewHolder>(),
   EditDialogFragment.EditDialogListener {

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context)
         .inflate(R.layout.row_item, parent, false)
      return ViewHolder(view)
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val history = historyList[position]
      holder.bind(history)
   }



   override fun getItemCount(): Int {
      return historyList.size
   }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private val refTextView: TextView = itemView.findViewById(R.id.textViewRef)
      private val quantityTextView: TextView = itemView.findViewById(R.id.textViewQuantity)
      private val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
      private val inOutTextView: TextView = itemView.findViewById(R.id.textViewInOut)
      private val deleteButton: ImageButton = itemView.findViewById(R.id.del_btn)

      fun bind(history: History) {
         refTextView.text = history.reference
         quantityTextView.text = history.quatity.toString()
         dateTextView.text = history.date.toString()
         inOutTextView.text=history.in_out

         deleteButton.setOnClickListener {
            showDeleteConfirmationDialog(history)
         }

         itemView.setOnLongClickListener {
            showEditDialog(history)
            true
         }
      }

      private fun showDeleteConfirmationDialog(history: History) {
         val alertDialogBuilder = AlertDialog.Builder(context)
         alertDialogBuilder.setTitle("Confirm Deletion")
         alertDialogBuilder.setMessage("Are you sure you want to delete this item?")
         alertDialogBuilder.setPositiveButton("Yes") { dialog, _ ->
            GlobalScope.launch {
               historyDao.deleteHistory(history)
            }
            dialog.dismiss()
         }
         alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
         }
         val alertDialog = alertDialogBuilder.create()
         alertDialog.show()
      }

      private fun showEditDialog(history: History) {
         val dialog = EditDialogFragment(history)
         dialog.setListener(this@DashboardAdapterL)
         dialog.show((context as AppCompatActivity).supportFragmentManager, "EditDialogFragment")
      }
   }

   override fun onSaveClicked(updatedHistory: History) {
      GlobalScope.launch {
         historyDao.updateHistory(updatedHistory)
      }

   }
}
