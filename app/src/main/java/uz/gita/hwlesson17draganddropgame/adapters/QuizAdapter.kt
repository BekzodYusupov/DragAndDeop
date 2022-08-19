package uz.gita.hwlesson17draganddropgame.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.hwlesson17draganddropgame.R
import uz.gita.hwlesson17draganddropgame.utils.MyDiffUtil

class QuizAdapter : RecyclerView.Adapter<QuizAdapter.VH>() {
    private val dataList: ArrayList<String> = ArrayList()

    fun submitList(variants: ArrayList<String>) {
        val callBack = MyDiffUtil(dataList,variants)
        val calculate = DiffUtil.calculateDiff(callBack)
        dataList.clear()
        dataList.addAll(variants)
        calculate.dispatchUpdatesTo(this)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        private val variant:TextView = itemView.findViewById(R.id.tvVariant)

        fun bind() {
            val item = dataList[adapterPosition]
            variant.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_raw, parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int)  = holder.bind()

    override fun getItemCount(): Int = dataList.size
}