package br.com.sam.raizes.capoeira.asynctask

import android.os.AsyncTask

class BaseAsyncTask<T>(
    private val whenPerforms: () -> T,
    private val whenEnds: (resultado: T) -> Unit
) : AsyncTask<Void, Void, T>() {

    override fun doInBackground(vararg params: Void?) = whenPerforms()

    override fun onPostExecute(resultado: T) {
        super.onPostExecute(resultado)
        whenEnds(resultado)
    }

}