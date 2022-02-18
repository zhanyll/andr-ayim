package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.EditEmployeeFragmentBinding

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

        binding.apply {
            val e = dbInstance.employeeDao().getById(1L)

            editButton.setOnClickListener {
                e.name = editName.text.toString()
                e.company = editCompany.text.toString()
                e.salary = editSalary.text.toString().toInt()
                dbInstance.employeeDao().update(e)
                listener.onMain()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}