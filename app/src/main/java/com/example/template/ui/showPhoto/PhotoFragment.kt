package com.example.template.ui.showPhoto

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.template.R
import com.example.template.ui.MainActivity
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener
import kotlinx.android.synthetic.main.fragment_show_photo.*


class PhotoFragment : Fragment() {

    private val args: PhotoFragmentArgs by navArgs()
    private var photo: Bitmap? = null
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        mainActivity = activity as MainActivity

        loadImage()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_photo, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_set_wallpaper -> {
                if (photo == null) {
                    showLoadingWarning()
                } else {
                    setWallpaperBitmap()
                }
                return true
            }
            R.id.action_share -> {
                if (photo == null) {
                    showLoadingWarning()
                } else {
                    performSharing()
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadImage() {
        ImageLoader.getInstance().loadImage(args.photoUrl, object : SimpleImageLoadingListener() {
            override fun onLoadingComplete(imageUri: String, view: View?, loadedImage: Bitmap) {
                if (!activity?.isFinishing()!!) {
                    photo = loadedImage
                    nasaImage.setImage(ImageSource.cachedBitmap(loadedImage))
                    progress.visibility = View.GONE
                }
            }
        })
    }

    private fun setWallpaperBitmap() {
        val wallpaperManager =
            WallpaperManager.getInstance(mainActivity.applicationContext)
        wallpaperManager.setBitmap(photo)
        Toast.makeText(context, R.string.set_as_wallpaper_completed, Toast.LENGTH_SHORT).show()
    }

    private fun performSharing() {
        val path = MediaStore.Images.Media.insertImage(
            mainActivity.contentResolver, photo, args.photoUrl, "")
        val uri = Uri.parse(path)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/jpeg"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(Intent.createChooser(intent, getString(R.string.share)))
    }

    private fun showLoadingWarning() {
        Toast.makeText(context, getString(R.string.photo_is_loading), Toast.LENGTH_SHORT).show()
    }
}