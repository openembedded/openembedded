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

SRC_URI[md5sum] = "f9185cc10aded1b8d32329369fb00dcb"
SRC_URI[sha256sum] = "46b84f8850f39c2d329abedbe40eb827644c11e2a05929911d54181bac663921"
