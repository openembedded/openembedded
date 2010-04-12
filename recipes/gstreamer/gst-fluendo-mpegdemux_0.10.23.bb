DESCRIPTION = "MPEG demuxers"
LICENSE = "MPL"

DEPENDS = "gstreamer liboil"

SRC_URI = "http://core.fluendo.com/gstreamer/src/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools

acpaths = "-I common/m4"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"



SRC_URI[md5sum] = "dd1923a4b3c397b16286bc7a903f5e75"
SRC_URI[sha256sum] = "e8da54a2cc35e6cc4876cb64b00b20e9b7058806ff1ff7f4da002b14f4652b4f"
