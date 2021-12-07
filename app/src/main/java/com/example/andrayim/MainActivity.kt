package com.example.andrayim

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.andrayim.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            one.setOnClickListener { expression("1", true) }
            two.setOnClickListener { expression("2", true) }
            three.setOnClickListener { expression("3", true) }
            four.setOnClickListener { expression("4", true) }
            five.setOnClickListener { expression("5", true) }
            six.setOnClickListener { expression("6", true) }
            seven.setOnClickListener { expression("7", true) }
            eight.setOnClickListener { expression("8", true) }
            nine.setOnClickListener { expression("9", true) }
            zero.setOnClickListener { expression("0", true) }
            point.setOnClickListener { expression(".", true) }
            plus.setOnClickListener { expression("+", false) }
            minus.setOnClickListener { expression("-", false) }
            div.setOnClickListener { expression("/", false) }
            multiply.setOnClickListener { expression("*", false) }
            openP.setOnClickListener { expression("(", false) }
            closeP.setOnClickListener { expression(")", false) }

            back.setOnClickListener {
                val expr = expression.text.toString()
                if (expr != "") {
                    expression.text = expr.substring(0, expr.length - 1)
                }
                result.text = ""
            }
            clear.setOnClickListener {
                expression.text = ""
                result.text = ""
            }
            equal.setOnClickListener {
                try {
                    val expr = ExpressionBuilder(expression.text.toString()).build()
                    val res = expr.evaluate()
                    result.text = res.toString()
                } catch (exception: Exception) {
                    Log.e("exception", "$exception")
                }
            }
        }
    }

    fun expression(string: String, clear: Boolean) {
        if (binding.result.text.isNotEmpty()) {
            binding.result.text = ""
        }

        if (clear) {
            binding.result.text = ""
            binding.expression.append(string)
        } else {
            binding.expression.append(binding.result.text)
            binding.expression.append(string)
            binding.result.text = ""
        }
    }
}