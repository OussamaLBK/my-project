import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.stockmanagement.R
import com.example.stockmanagement.db.History

class EditDialogFragment(private val history: History) : DialogFragment() {

    private lateinit var editTextRef: EditText
    private lateinit var editTextQuantity: EditText
    private lateinit var editTextDate: EditText
    private lateinit var buttonSave: Button
    private var listener: EditDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_form_layout, container, false)

        editTextRef = view.findViewById(R.id.editTextRef)
        editTextQuantity = view.findViewById(R.id.editTextQuantity)
        editTextDate = view.findViewById(R.id.editTextDate)
        buttonSave = view.findViewById(R.id.buttonSave)

        // Populate the EditTexts with the data from the selected history item
        editTextRef.setText(history.reference)
        editTextQuantity.setText(history.quatity.toString())
        editTextDate.setText(history.date.toString())

        buttonSave.setOnClickListener {
            // Get the updated values from the EditTexts
            val updatedReference = editTextRef.text.toString()
            val updatedQuantity = editTextQuantity.text.toString().toInt()
            val updatedDate = editTextDate.text.toString()

            // Update the history item
            val updatedHistory = history.copy(reference = updatedReference, quatity = updatedQuantity, date = updatedDate)
            // Call a listener to handle the save action
            listener?.onSaveClicked(updatedHistory)
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
        fun onSaveClicked(updatedHistory: History)
    }
}