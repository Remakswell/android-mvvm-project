package com.example.template.ui.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.template.R
import com.example.template.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_select_photo.*
import javax.inject.Inject


@AndroidEntryPoint
class SelectPhotoFragment : BaseFragment() {

    private var dateArg: String? = null

    @Inject
    lateinit var viewModel: SelectPhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dateArg = it.getString(DATE_KEY)
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

        showProgress()

        val selectPhotoAdapter = SelectPhotoAdapter()
        listWithDates.adapter = selectPhotoAdapter
        dateArg.let { viewModel.getNasaPhotos(it!!) }

        viewModel.nasaPhotos.observe(viewLifecycleOwner, Observer { nasaPhotos ->
            hideProgress()
            selectPhotoAdapter.data = nasaPhotos
        })
    }

    companion object {
        const val DATE_KEY = "date_key"
    }
}