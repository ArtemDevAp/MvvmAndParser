package ru.qman.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_first.view.*
import ru.qman.myapplication.R
import ru.qman.myapplication.viewmodels.CoronaViewModel

class CoronaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)


        val cases = view.cases
        val death = view.death
        val recovered = view.recovered

        val coronaViewModel = ViewModelProvider(this).get(CoronaViewModel::class.java)
        coronaViewModel.getData().observe(viewLifecycleOwner, Observer {
            cases.text = it.cases
            death.text =  it.deaths
            recovered.text = it.recovered
        })


        coronaViewModel.error().observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })

        return view
    }

}