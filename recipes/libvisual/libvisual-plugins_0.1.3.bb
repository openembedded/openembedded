DESCRIPTION = "A cross platform audio visualization library"
HOMEPAGE = "http://libvisual.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
# FIXME: current depends dont support versioned deps well
# DEPENDS = "libvisual (${PV})"
DEPENDS = "libvisual"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvisual/libvisual-plugins-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${libdir}/libvisual/actor/*.so ${libdir}/libvisual/morph/*.so"
