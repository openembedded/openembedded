DESCRIPTION = "Gizmo Daemon"
HOMEPAGE = "http://gizmod.sourceforge.net"
LICENSE = "AL2.0"
SECTION = "console/multimedia"
DEPENDS = "python virtual/libx11 xf86vidmodeproto alsa-lib boost libvisual"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/gizmod/gizmod-${PV}.tar.bz2 \
	file://${PV}-build-fix.patch;patch=1 \
	"

PR = "r0"

inherit cmake

do_install_append() {
  mv ${D}/usr/${sysconfdir} ${D}
}

FILES_${PN} += "${libdir}/libvisual/actor/lib*.so"
FILES_${PN}-dbg += "${sysconfdir} ${libdir}/libvisual/actor/.debug/lib*.so"
