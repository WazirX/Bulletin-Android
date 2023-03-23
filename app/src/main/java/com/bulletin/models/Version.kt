package com.bulletin.models

import com.bulletin.extension.validVersion
import java.io.Serializable

data class Version(val version: String) : Serializable {

     companion object {

          fun init(version: String): Version? {

               // Set Title
               val validVersion = version.validVersion() ?: return null

               return Version(validVersion)
          }
     }

}
