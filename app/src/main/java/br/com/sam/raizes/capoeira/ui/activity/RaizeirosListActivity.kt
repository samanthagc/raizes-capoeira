package br.com.sam.raizes.capoeira.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.sam.raizes.capoeira.R
import br.com.sam.raizes.capoeira.database.AppDatabase
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.ui.recycleview.adapter.RaizeirosListAdapter
import br.com.sam.raizes.capoeira.ui.viewmodel.RaizeirosListViewModel
import br.com.sam.raizes.capoeira.ui.viewmodel.factory.RaizeirosListViewModelFactory
import kotlinx.android.synthetic.main.activity_raizeiros_list.*

private const val APPBAR_TITLE = "raizeiros"

class RaizeirosListActivity : AppCompatActivity() {

    private val adapter by lazy {
        RaizeirosListAdapter(context = this)
    }
    private val viewModel by lazy {
        val repository = RaizeiroRepository(AppDatabase.getInstance(this).raizeiroDAO)
        val factory = RaizeirosListViewModelFactory(repository)
        val provider = ViewModelProviders.of(this, factory)
        provider.get(RaizeirosListViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raizeiros_list)
        appbarConfig()
        recyclerViewConfig()
        fabNewRaizeiroConfig()
        getRaizeiros()
    }

    private fun appbarConfig() {
        title = APPBAR_TITLE
    }

    private fun fabNewRaizeiroConfig() {
        fab_list_add_raizeiro.setOnClickListener {
            val intent = Intent(this, RaizeiroFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recyclerViewConfig() {
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        rv_raizeiros_list.addItemDecoration(divisor)
        rv_raizeiros_list.adapter = adapter
    }

    private fun getRaizeiros() {
        viewModel.getAll().observe(this, Observer { resource ->
            resource.data?.let { adapter.update(it) }
        })
    }
}
