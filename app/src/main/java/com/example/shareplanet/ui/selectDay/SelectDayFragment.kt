package com.example.shareplanet.ui.selectDay


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shareplanet.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_select_day.*
import javax.inject.Inject

@AndroidEntryPoint
class SelectDayFragment : Fragment() {

    @Inject
    lateinit var viewModel: SelectDayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_select_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainAdapter = SelectDayAdapter()
        val layoutManager = GridLayoutManager(context, 2)
        dateList.layoutManager = layoutManager
        dateList.adapter = mainAdapter

        viewModel.dataInfo.observe(viewLifecycleOwner, Observer { nasaDates ->
                progress.visibility = View.GONE
                mainAdapter.data = nasaDates
        })
    }
}