package com.bulletin.extension


fun String.isNumeric(): Boolean {
    if (this.isEmpty()) {
        return false
    }
    val e = this.takeIf { it.isNotEmpty() } ?: return false
    this.toUIntOrNull()?.let { return true } ?: return false
}

fun String.validVersion(): String? {

    // Convert String In to Array
    val versionBlocks = this.split(".").toTypedArray()

    // Validation
    if (versionBlocks.size == 0) return null

    // Validation For String as Int
    for (versionBlock in versionBlocks)  {
        if (versionBlock.isNumeric() == false) {
            return null
        }
    }

    return versionBlocks.joinToString(".")
}
