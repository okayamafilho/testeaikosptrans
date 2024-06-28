package br.com.okayamafilho.testeaikosptrans

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.okayamafilho.testeaikosptrans.R.*
import br.com.okayamafilho.testeaikosptrans.R.drawable.img_ponto
import br.com.okayamafilho.testeaikosptrans.databinding.ActivityMainBinding
import br.com.okayamafilho.testeaikosptrans.databinding.CardItemBuslineBinding
import com.squareup.picasso.Picasso

class BuslineAdapter : RecyclerView.Adapter<BuslineAdapter.BuslineViewHolder>() {

    private var listaBusline = emptyList<String>()

    fun adicionarLista(lista: List<String>) {
        listaBusline = lista
        notifyDataSetChanged()
    }

    inner class BuslineViewHolder(val binding: CardItemBuslineBinding) : ViewHolder(binding.root) {
        fun bind(url: String) {

            Picasso.get()
                .load(img_ponto)
                .into(binding.imageView)

            binding.txtBusline.text = "linha do bus"
            binding.txtDescbusline.text = "descricao da linha do bus"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuslineViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = CardItemBuslineBinding.inflate(
            layoutInflater, parent, false

        )
        return BuslineViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BuslineViewHolder, position: Int) {
        val url = listaBusline[position]
        holder.bind(url)
    }

    override fun getItemCount(): Int {
        return listaBusline.size
    }

}