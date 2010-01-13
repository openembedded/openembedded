DESCRIPTION = "MPEG demuxers"
LICENSE = "MPL"

DEPENDS = "gstreamer liboil"

SRC_URI = "http://core.fluendo.com/gstreamer/src/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools

acpaths = "-I common/m4"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"


