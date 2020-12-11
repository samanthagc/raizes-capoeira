package br.com.sam.raizes.capoeira.ui.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.sam.raizes.capoeira.R
import br.com.sam.raizes.capoeira.model.Raizeiro
import br.com.sam.raizes.capoeira.ui.recycleview.adapter.RaizeirosListAdapter.ViewHolder
import kotlinx.android.synthetic.main.raizeiro_item.view.*

class RaizeirosListAdapter(
    private val context: Context,
    private val raizeiros: MutableList<Raizeiro> = mutableListOf(),
    var whenItemClicked: (raizeiro: Raizeiro) -> Unit = {}
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val createdView = LayoutInflater.from(context)
            .inflate(R.layout.raizeiro_item, parent, false)
        return ViewHolder(createdView)
    }

    override fun getItemCount() = raizeiros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val raizeiro = raizeiros[position]
        holder.attach(raizeiro)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var raizeiro: Raizeiro

        init {
            itemView.setOnClickListener {
                if (::raizeiro.isInitialized) {
                    whenItemClicked(raizeiro)
                }
            }
        }

        fun attach(raizeiro: Raizeiro) {
            this.raizeiro = raizeiro
            itemView.tv_nickname.text = raizeiro.nickname
            itemView.tv_name.text = raizeiro.name
            itemView.tv_graduation.text = raizeiro.graduation
        }

    }

}