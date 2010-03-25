require libgpod.inc

DEPENDS += "sqlite3 libplist libimobiledevice"

EXTRA_OECONF = "  --enable-udev "

SRC_URI[archive.md5sum] = "81697d25c1c4bfd6d9fe7653fe5b16cf"
SRC_URI[archive.sha256sum] = "5d04047b25d225ee7a06a1527aab22e8bb95b4b23e347fba8d2a3ad55787bd05"

FILES_${PN} += "${libdir}/hal /lib/udev/ ${datadir}/hal"
FILES_${PN}-dbg += "${libdir}/hal/scripts/.debug /lib/udev/.debug"


