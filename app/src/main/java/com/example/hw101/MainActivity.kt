package com.example.hw101
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw101.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    val presenter= Injector.getPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }
    private fun initClickers() {
        with(binding){
            plusButton.setOnClickListener {
                presenter.increment()
            }
            minusButton.setOnClickListener {
                presenter.decrement()
            }
        }
    }
    override fun showChangeCount(count: Int) {
        binding.countTv.text=count.toString()
    }

    override fun showToast() {
        Toast.makeText(this@MainActivity, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.countTv.setTextColor(Color.GREEN)
    }
}