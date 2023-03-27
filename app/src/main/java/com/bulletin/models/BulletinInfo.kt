package com.bulletin.models

import com.bulletin.utilities.VersionUtil
import java.io.Serializable

class BulletinInfo(var version: Version, var items: List<BulletinItem>) : Serializable {

    companion object {
        fun init(version: Version, items: MutableList<BulletinItem>): BulletinInfo {
            return BulletinInfo(version, items)
        }

        var descendingSort: Comparator<BulletinInfo> =
            Comparator { t2: BulletinInfo, t1: BulletinInfo ->
                VersionUtil.versionCompare(t1.version.version, t2.version.version)
            }
    }

}
