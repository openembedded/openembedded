DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries."
DEPENDS = "evas-x11 ecore-x11 edje"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI = "http://enlightenment.freedesktop.org/files/etk-${PV}.tar.gz"

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/etk/engines/*.so"
FILES_${PN}-dev += "${libdir}/etk/engines/*.a ${libdir}/etk/engines/*.la"
FILES_${PN}-dbg += "${libdir}/etk/engines/*/.debug/"

