package br.com.sam.raizes.capoeira.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.sam.raizes.capoeira.R
import br.com.sam.raizes.capoeira.database.AppDatabase
import br.com.sam.raizes.capoeira.model.Raizeiro
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.ui.viewmodel.RaizeiroFormViewModel
import br.com.sam.raizes.capoeira.ui.viewmodel.factory.RaizeiroFormViewModelFactory
import kotlinx.android.synthetic.main.activity_raizeiro_form.*

class RaizeiroFormActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val repository = RaizeiroRepository(AppDatabase.getInstance(this).raizeiroDAO)
        val factory = RaizeiroFormViewModelFactory(repository)
        ViewModelProviders.of(this, factory)
            .get(RaizeiroFormViewModel::class.java)
    }

    private var graduationSelected: String = ""
    private lateinit var graduations: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raizeiro_form)
        inicializeVariables()
        spinnerConfig()
    }

    private fun inicializeVariables() {
        this.graduations = resources.getStringArray(R.array.graduations)
        Log.e("DANIELLE", " ------- " +graduations[0] + " --- " + graduations)
    }

    private fun spinnerConfig() {
        val spinner = findViewById<Spinner>(R.id.sp_graduation)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, graduations)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                graduationSelected = graduations[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.raizeiro_form_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.saved_raizeiro_form -> {
                val nickname = ed_nickname.text.toString()
                val name = ed_name.text.toString()
                save(Raizeiro(nickname = nickname, name = name, graduation = graduationSelected))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun save(raizeiro: Raizeiro) {
        viewModel.save(raizeiro).observe(this, Observer {
            Toast.makeText(
                this,
                raizeiro.name + " - " + raizeiro.nickname + " - " + raizeiro.graduation,
                Toast.LENGTH_LONG
            ).show()
        })
    }
}
