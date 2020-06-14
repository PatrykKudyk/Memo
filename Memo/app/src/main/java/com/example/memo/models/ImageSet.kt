package com.example.memo.models

import android.widget.ImageView

class ImageSet(
    val imageView: ImageView,
    var isOpened: Boolean,
    var imageNumber: Int,
    var isDone: Boolean
) {
}