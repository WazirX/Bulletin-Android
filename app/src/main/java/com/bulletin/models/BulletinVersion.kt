package com.bulletin.models

import com.bulletin.utilities.VersionUtil

data class BulletinVersion(val versionNumber: String, val items: MutableList<BulletinItem>) {

    companion object {
        var descendingSort: Comparator<BulletinVersion> =
            Comparator { t2: BulletinVersion, t1: BulletinVersion ->
                VersionUtil.versionCompare(t1.versionNumber, t2.versionNumber)
            }

    }

}