package com.example.stockmanagement.ui.lighting

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.stockmanagement.R
import com.example.stockmanagement.db.Dashboard
import com.example.stockmanagement.db.History

class EditDialogFragmentDL(private val dashboard: Dashboard) : DialogFragment() {

    private lateinit var editTextRef: EditText
    private lateinit var editTextQuantity: EditText

    private lateinit var buttonSave: Button
    private var listener: EditDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_form_layout1, container, false)

        editTextRef = view.findViewById(R.id.editTextRef)
        editTextQuantity = view.findViewById(R.id.editTextQuantity)

        buttonSave = view.findViewById(R.id.buttonSave)

        // Populate the EditTexts with the data from the selected history item
        editTextRef.setText(dashboard.reference)
        editTextQuantity.setText(dashboard.quatity.toString())


        buttonSave.setOnClickListener {
            // Get the updated values from the EditTexts
            val updatedReference = editTextRef.text.toString()
            val updatedQuantity = editTextQuantity.text.toString().toInt()


            // Update the history item
            val updatedDashboard = dashboard.copy(reference = updatedReference, quatity = updatedQuantity)
            // Call a listener to handle the save action
            listener?.onSaveClicked(updatedDashboard)
            dismiss()
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setTitle("Edit History")
        }
    }

    fun setListener(listener: EditDialogListener) {
        this.listener = listener
    }

    interface EditDialogListener {
        fun onSaveClicked(updatedDashboard: Dashboard)
    }
}