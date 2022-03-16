package com.rathanavoy.plantstore.repository

import android.net.Uri

interface LocalFileRepository {

    suspend fun readFile()

    suspend fun writeFile(content: String, fileUri: Uri)

}