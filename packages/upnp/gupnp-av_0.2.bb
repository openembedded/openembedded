LICENSE = "LGPL"
DEPENDS = "gnupnp gstreamer"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}


FILES_${PN} = "${libdir}/*.so.*"
