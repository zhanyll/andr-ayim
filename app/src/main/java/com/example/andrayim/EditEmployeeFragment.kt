package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.EditEmployeeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EditEmployeeFragment: Fragment(R.layout.edit_employee_fragment) {
    private val dbInstance get() = Injector.database
    private var _binding: EditEmployeeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: Clicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditEmployeeFragmentBinding.bind(view)
        val id = arguments?.getLong("id") ?: 1L

        binding.apply {
            editButton.setOnClickListener {
                dbInstance.employeeDao().getById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess {e ->
                        e.name = editName.text.toString()
                        e.company = editCompany.text.toString()
                        e.salary = editSalary.text.toString().toInt()
                        listener.onMain()
                        dbInstance.employeeDao().update(e)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                    }
                    .subscribe()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}