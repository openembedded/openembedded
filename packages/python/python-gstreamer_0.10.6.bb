LICENSE = "GPL"
DESCRIPTION = "Python gstreamer Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://gstreamer.freedesktop.org"
PRIORITY = "optional"
#DEPENDS = "gstreamer"
#RDEPENDS = "gstreamer"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-python/gst-python-${PV}.tar.gz"
S = "${WORKDIR}/gst-python-${PV}"

inherit autotools pkgconfig

do_configure() {
	oe_runconf
}
