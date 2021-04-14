package com.example.template.ui.showPhoto

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.template.R
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener
import kotlinx.android.synthetic.main.fragment_show_photo.*


class PhotoFragment : Fragment() {

    private var photoArg: String? = null

    private lateinit var photo: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            photoArg = it.getString(PHOTO_ARG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        ImageLoader.getInstance().loadImage(photoArg, object : SimpleImageLoadingListener() {
            override fun onLoadingComplete(imageUri: String, view: View?, loadedImage: Bitmap) {
                if (!activity?.isFinishing()!!) {
                    photo = loadedImage
                    scaleImage.setImage(ImageSource.cachedBitmap(loadedImage))
                    progress.visibility = View.GONE
                }
            }
        })

    }

    companion object {
        const val PHOTO_ARG = "photo_arg"
    }
}