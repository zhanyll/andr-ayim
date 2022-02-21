package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.EmployeeFragmentBinding

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
            val e = dbInstance.employeeDao().getById(id)
            txtName.text = e.name
            txtCompany.text = e.company
            txtSalary.text = e.salary.toString()

            btnDelete.setOnClickListener {
                dbInstance.employeeDao().delete(e)
                listener.onMain()
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