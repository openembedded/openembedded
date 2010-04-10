DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-desktop/0.8/matchbox-desktop-${PV}.tar.bz2 \
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

SRC_URI[md5sum] = "f7838ae67134e60bc2afb68022404b5f"
SRC_URI[sha256sum] = "9587182aab427103a8a1f9714dc16603c3a861076f7cd18d73321c3878b2048f"
