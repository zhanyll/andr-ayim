package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.database.Employee
import com.example.andrayim.databinding.AddEmployeeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddEmployeeFragment: Fragment(R.layout.add_employee_fragment) {
    private var _binding: AddEmployeeFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: Clicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AddEmployeeFragmentBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {
                val e = Employee(
                    name = editName.text.toString(),
                    company = editCompany.text.toString(),
                    salary = editSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
                listener.onMain()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}