package br.com.jpescola.parouimpar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var resultado = 0
    private var score = 0
    private var minhaTAG = "ParOuImpar"
    lateinit var txtResultado: TextView
    lateinit var btnNovo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // gera um registro
        Log.i(minhaTAG, "O aplicativo foi iniciado...")

        // inicialização dos componentes da UI
        txtResultado = findViewById(R.id.txtResultado)
        btnNovo = findViewById(R.id.btnNovo)

        // recupera o score antigo
        score = getPreferences(MODE_PRIVATE).getInt("SCORE", 0)
        title = "Last Score: $score"

        // dispara a função na inicialização
        novoJogo()
    }

    private fun novoJogo(){
        txtResultado.text = "Par ou Ímpar?"
        resultado = Random.nextInt(0,10)
        btnNovo.visibility = View.INVISIBLE
    }

    fun novoJogo(view: View){
        novoJogo()
    }

    fun jogada(view: View){
        if (resultado % 2 == view.tag.toString().toInt())
            if (btnNovo.visibility == View.INVISIBLE) {
                score++
                getPreferences(MODE_PRIVATE).edit().putInt("SCORE", score).commit() // salvar
            }
        title = "Score: $score"
        txtResultado.text = "$resultado"

        btnNovo.visibility = View.VISIBLE
    }
}