require libgpod-bz2.inc

PR = "r0"

DEPENDS += "sqlite3 libplist libimobiledevice"

EXTRA_OECONF = "  --enable-udev "

SRC_URI[archive.md5sum] = "ff0fd875fa08f2a6a49dec57ce3367ab"
SRC_URI[archive.sha256sum] = "0054e9b0060d7b923cdc1b748b6617f4dc9f1401fb6bc9368f9960537c55a092"

FILES_${PN} += "${libdir}/hal /lib/udev/ ${datadir}/hal"
FILES_${PN}-dbg += "${libdir}/hal/scripts/.debug /lib/udev/.debug"



