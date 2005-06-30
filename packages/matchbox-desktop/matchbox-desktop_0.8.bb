SECTION = "x11/wm"
PR = "r1"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"

SRC_URI = "ftp://ftp.handhelds.org/matchbox/sources/matchbox-desktop/${PV}/matchbox-desktop-${PV}.tar.bz2"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/matchbox/desktop/modules/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps"

FILES_${PN}-dev = "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${datadir}/matchbox/desktop/modules/*a"
