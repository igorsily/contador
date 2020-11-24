package br.com.igorsily.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.igorsily.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy { loadViewModel() }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.viewModel = mainViewModel

        binding.podeEntrarNaoPodeEntrar.text = getString(R.string.podeEntrar)

        mainViewModel.countPeople.observe(this, changeText)
    }


    private val changeText = Observer<Int> { count ->

        binding.btnMinus.isEnabled = count != 0

        binding.podeEntrarNaoPodeEntrar.text =
            if (count >= 10) getString(R.string.naoPodeEntrar) else getString(R.string.podeEntrar)

        binding.peopleText.text = getString(R.string.pessoas, count)


    }


    private fun loadViewModel(): MainViewModel =
        ViewModelProvider(this, MainViewModel.Factory(this)).get(MainViewModel::class.java)
}


