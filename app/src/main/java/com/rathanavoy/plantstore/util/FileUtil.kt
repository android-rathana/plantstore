package com.rathanavoy.plantstore.util

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object FileUtil {

    fun createCacheFile(context: Context, fileName: String): File {
        return File(context.cacheDir, fileName)
    }

    fun writeFile(file: File, content: ByteArray, appendable: Boolean = false) {
        return FileOutputStream(file, appendable).use {
            it.writer(charset("utf-8"))
            it.write(content)
            it.flush()
        }
    }

}