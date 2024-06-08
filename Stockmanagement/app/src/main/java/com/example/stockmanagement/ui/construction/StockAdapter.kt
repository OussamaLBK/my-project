import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.db.Product
import com.example.stockmanagement.db.ProductDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StockAdapter(
    private val context: Context,
    private val productList: List<Product>,
    private val productDao: ProductDao
) :
    RecyclerView.Adapter<StockAdapter.ViewHolder>(),
    EditDialogFragmentD.EditDialogListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val refTextView: TextView = itemView.findViewById(R.id.textViewRef)
        private val quantityTextView: TextView = itemView.findViewById(R.id.textViewQuantity)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.del_btn)

        fun bind(product: Product) {
            refTextView.text = product.name
            quantityTextView.text = product.reference

            deleteButton.setOnClickListener {
                showDeleteConfirmationDialog(product)
            }

            itemView.setOnLongClickListener {
                showEditDialog(product)
                true
            }
        }

        private fun showDeleteConfirmationDialog(product: Product) {
            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setTitle("Confirm Deletion")
            alertDialogBuilder.setMessage("Are you sure you want to delete this item?")
            alertDialogBuilder.setPositiveButton("Yes") { dialog, _ ->
                GlobalScope.launch {
                    productDao.deleteProduct(product)
                }
                dialog.dismiss()
            }
            alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

        private fun showEditDialog(product: Product) {
            val dialog = EditDialogFragmentD(product)
            dialog.setListener(this@StockAdapter)
            dialog.show((context as AppCompatActivity).supportFragmentManager, "EditDialogFragment")
        }
    }

    override fun onSaveClicked(updatedProduct: Product) {
        GlobalScope.launch {
            productDao.updateProduct(updatedProduct)
        }
    }
}
