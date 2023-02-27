package com.bulletin.utilities

import android.content.pm.PackageManager
import com.bulletin.BulletinApp
import com.bulletin.extension.isEmpty

object VersionUtil {

    /**
     * if v1>v2 : returns 1
     * if v1<v2 : returns -1
     * if v1==v2 : returns 0
     * */
    fun versionCompare(v1: String?, v2: String?): Int {
        if (v1 == null || v1.isEmpty()) return -1
        if (v2 == null || v2.isEmpty()) return 1
        if (v1.isEmpty() && v2.isEmpty()) return 0

        // vnum stores each numeric part of version
        var vnum1 = 0
        var vnum2 = 0

        // loop until both String are processed
        var i = 0
        var j = 0
        while (i < v1.length
            || j < v2.length
        ) {

            // Storing numeric part of
            // version 1 in vnum1
            while (i < v1.length
                && v1[i] != '.'
            ) {
                vnum1 = (vnum1 * 10
                        + (v1[i] - '0'))
                i++
            }

            // storing numeric part
            // of version 2 in vnum2
            while (j < v2.length
                && v2[j] != '.'
            ) {
                vnum2 = (vnum2 * 10
                        + (v2[j] - '0'))
                j++
            }
            if (vnum1 > vnum2) return 1

            if (vnum2 > vnum1) return -1

            // if equal, reset variables and
            // go for next numeric part
            vnum2 = 0
            vnum1 = vnum2
            i++
            j++
        }
        return 0
    }

    fun getLatestVersion(v1: String?, v2: String?): String? {
        if (v1.isEmpty()) return v2
        if (v2.isEmpty()) return v1

        // if (v1!=null && v2!=null) call versionCompare
        return if (v1?.let { v2?.let { it1 -> versionCompare(it, it1) } } == -1) {
            v2
        } else {
            v1
        }
    }

    fun getApplicationVersion(): String? {
        try {
            val pInfo =
                BulletinApp.shared.packageManager.getPackageInfo(BulletinApp.shared.packageName, 0)
            return pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getVersionInAscendingOrder(set: MutableSet<String>): List<String> {
        val list: List<String> = set.toList()
        return list.sortedWith { version, version1 -> versionCompare(version1, version) };
    }

}
