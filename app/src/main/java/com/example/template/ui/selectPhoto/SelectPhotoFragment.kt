package com.example.template.ui.selectPhoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.template.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_select_photo.*
import javax.inject.Inject


@AndroidEntryPoint
class SelectPhotoFragment : Fragment() {

    private var dateArg: String? = null

    @Inject
    lateinit var viewModel: SelectPhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dateArg = it.getString(DATE_ARG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectPhotoAdapter = SelectPhotoAdapter()
        listWithDates.adapter = selectPhotoAdapter
        dateArg.let { viewModel.getNasaPhotos(it!!) }

        viewModel.nasaPhotos.observe(viewLifecycleOwner, Observer { nasaPhotos ->
            progress.visibility = View.GONE
            selectPhotoAdapter.data = nasaPhotos
        })
    }

    companion object {
        const val DATE_ARG = "date_arg"
    }
}