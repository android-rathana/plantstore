package com.rathanavoy.plantstore.repository.local

import android.net.Uri
import com.rathanavoy.plantstore.repository.LocalFileRepository

class LocalFIleRepositoryImpl : LocalFileRepository {

    override suspend fun writeFile(content: String, fileUri: Uri) {

    }

    override suspend fun readFile() {

    }
}