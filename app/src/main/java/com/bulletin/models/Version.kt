package com.bulletin.models

import com.bulletin.extension.validVersion

//data class Version(val versionNumber: String) {
//     lateinit var version :String
//
//}

data class Version(val version: String) {

     companion object {

          fun init(version: String): Version? {

               // Set Title
               val validVersion = version.validVersion() ?: return null

               return Version(validVersion)
          }
     }

}
