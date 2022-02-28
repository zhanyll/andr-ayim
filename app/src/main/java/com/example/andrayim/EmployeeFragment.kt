package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.EmployeeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmployeeFragment: Fragment(R.layout.employee_fragment) {
    private val dbInstance get() = Injector.database
    private var _binding: EmployeeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: Clicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EmployeeFragmentBinding.bind(view)
        val id = arguments?.getLong("id") ?: 1L

        binding.apply {
            dbInstance.employeeDao().getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    txtName.text = it.name
                    txtCompany.text = it.company
                    txtSalary.text = it.salary.toString()
                }
                .subscribe()

            btnDelete.setOnClickListener {
                dbInstance.employeeDao().getById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess {
                        dbInstance.employeeDao().delete(it)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                        listener.onMain()
                    }
                    .subscribe()
            }

            btnEdit.setOnClickListener {
                listener.onEdit(id)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}