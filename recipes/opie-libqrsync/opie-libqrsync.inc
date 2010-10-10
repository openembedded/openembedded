DESCRIPTION = "Qt wrapper for librsync"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"

S = "${WORKDIR}/rsync"

inherit opie

do_install() {
        oe_libinstall -a libqrsync ${D}${libdir}/
        install -d ${D}${includedir}/
        install -m 0644 qrsync.h ${D}${includedir}/
}
