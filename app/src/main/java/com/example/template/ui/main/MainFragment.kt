package com.example.template.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.template.R
import com.example.template.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProgress()

        val mainAdapter = MainAdapter()
        val layoutManager = GridLayoutManager(context, 2)
        dateList.layoutManager = layoutManager
        dateList.adapter = mainAdapter

        viewModel.dataInfo.observe(viewLifecycleOwner, Observer { nasaDates ->
                hideProgress()
                mainAdapter.data = nasaDates

        })
    }
}