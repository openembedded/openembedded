DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"

SRC_URI = "ftp://ftp.handhelds.org/matchbox/sources/matchbox-desktop/0.8/matchbox-desktop-${PV}.tar.bz2 \
	   file://enable-file-manager.patch;patch=1"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${libdir}/matchbox/desktop/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps \
	       ${sysconfdir}/matchbox"

FILES_${PN}-dev = "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${datadir}/matchbox/desktop/modules/*a"
